package com.example.finewineapi.wine;

import com.example.finewineapi.models.*;
import com.example.finewineapi.savedWines.SavedWineEntity;
import com.example.finewineapi.savedWines.SavedWineRepository;
import com.example.finewineapi.variety.VarietyDTO;
import com.example.finewineapi.variety.VarietyService;
import com.example.finewineapi.winery.WineryDTO;
import com.example.finewineapi.winery.WineryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.finewineapi.currentRecommendations.CurrentRecommendationsEntity;
import com.example.finewineapi.currentRecommendations.CurrentRecommendationsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class WineServiceImpl implements WineService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    private final VarietyService varietyService;
    private final WineryService wineryService;
    private final WineRepository wineRepository;
    private final SavedWineRepository savedWineRepository;
    private final CurrentRecommendationsRepository currentRecommendationsRepository;

    public WineServiceImpl(WineRepository wineRepository,
                           CurrentRecommendationsRepository currentRecommendationsRepository,
                           VarietyService varietyService,
                           WineryService wineryService,
                           SavedWineRepository savedWineRepository) {
        this.wineRepository = wineRepository;
        this.currentRecommendationsRepository = currentRecommendationsRepository;
        this.varietyService = varietyService;
        this.wineryService = wineryService;
        this.savedWineRepository = savedWineRepository;
    }

    @Override
    public List<WineDTO> getWines() {
        List<WineEntity> wineEntityList = this.wineRepository.findAll();
        return wineEntityList
                .stream()
                .map(wineEntity -> modelMapper.map(wineEntity, WineDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<WineDTO> getBestRandomWines() {
        List<WineEntity> bestRandomWines = new ArrayList<>();
        bestRandomWines.add(getRandomWine("red"));
        bestRandomWines.add(getRandomWine("white"));
        bestRandomWines.add(getRandomWine("rose"));
        bestRandomWines.add(getRandomWine("sparkling"));
        return bestRandomWines
                .stream()
                .map(wineEntity -> modelMapper.map(wineEntity, WineDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<WineDTO> getRecommendations(WineRecommendationReq wineRecommendationReq) throws IOException, InterruptedException {
        List<String> defaultParams = Arrays.asList("python", "src/main/java/com/example/finewineapi/recommending_system.py");

        List<String> params = new ArrayList<>(defaultParams);
        params.add(";");
        params.addAll(wineRecommendationReq.getCountries().isEmpty() ? List.of("") : wineRecommendationReq.getCountries());
        params.add(";");
        params.addAll(wineRecommendationReq.getWineColors().isEmpty() ? List.of("") : wineRecommendationReq.getWineColors());
        params.add(";");

        ProcessBuilder processBuilder = new ProcessBuilder(params);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        List<String> pythonOutput = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            pythonOutput.add(line);
        }

        int exitCode = process.waitFor();

        if (exitCode == 0) {
            ObjectMapper objectMapper = new ObjectMapper();

            List<RecommendationJson> recommendations = new ArrayList<>();
            for (String outputLine : pythonOutput) {
                RecommendationJson recommendation = objectMapper.readValue(outputLine, RecommendationJson.class);
                recommendations.add(recommendation);
            }
            return recommendations
                    .stream()
                    .map(json -> modelMapper.map(json, WineDTO.class))
                    .collect(Collectors.toList());
        } else {
            System.err.println("Python script exited with an error: " + exitCode);
            return null;
        }
    }

    private WineEntity getRandomWine(String wineColor) {
        List<Long> randomWineIds = wineRepository.findIdsByWineColorAndPointsGreaterThan(wineColor, 80L);

        if (randomWineIds.isEmpty()) {
            return null; // No wines match the criteria
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(randomWineIds.size());
        Long randomWineId = randomWineIds.get(randomIndex);

        return wineRepository.findById(randomWineId).orElse(null);
    }

    @Override
    public void saveCurrentRecommendations(List<WineDTO> currentRecommendations) {
        List<CurrentRecommendationsEntity> recommendationEntities = new ArrayList<>();
        for (WineDTO wineDTO : currentRecommendations) {
            WineEntity wineEntity = this.wineRepository.findById(wineDTO.getId()).orElse(null); // Replace with your implementation
            CurrentRecommendationsEntity recommendationEntity = new CurrentRecommendationsEntity(wineEntity);
            recommendationEntities.add(recommendationEntity);
        }
        this.currentRecommendationsRepository.deleteAll();
        this.currentRecommendationsRepository.saveAll(recommendationEntities);
    }

    @Override
    public List<WineDTO> getCurrentRecommendations() {
        return new ArrayList<>(this.currentRecommendationsRepository.findAll()
                .stream().map(wine -> modelMapper.map(wine.getWine(), WineDTO.class)).toList());
    }

    @Override
    public FindWineRes getWinePageWithFilters(int pageNumber, FindWineReq findWineReq) {
        String nativeQuery =
                "SELECT * FROM wines as w WHERE " +
                "w.wine_color IS NOT NULL " +
                "AND w.variety IS NOT NULL " +
                "AND w.province IS NOT NULL " +
                "AND w.winery IS NOT NULL " +
                "AND w.country IS NOT NULL " +
                "AND w.points IS NOT NULL " +
                "AND w.description IS NOT NULL " +
                "AND (:colors IS NULL OR w.wine_color IN :colors) " +
                "AND (:varieties IS NULL OR w.variety IN :varieties) " +
                "AND (:countries IS NULL OR w.country IN :countries) " +
//                "AND (:provinces IS NULL OR w.province IN :provinces) " +
                "AND (:wineries IS NULL OR w.winery IN :wineries) " +
                "ORDER BY w.id";

        Query q = entityManager.createNativeQuery(nativeQuery, WineEntity.class);
        q.setParameter("colors", findWineReq.getWineColors());
        q.setParameter("varieties", findWineReq.getVarieties());
        q.setParameter("countries", findWineReq.getCountries());
//        q.setParameter("provinces", findWineReq.getProvinces());
        q.setParameter("wineries", findWineReq.getWineries());
        int offset = (pageNumber) * 10;

        q.setFirstResult(offset);
        q.setMaxResults(10);

        List<WineEntity> entities = q.getResultList();

        Page<WineDTO> winess = new PageImpl<>(
                entities
                    .stream()
                    .map(wineObject -> modelMapper.map(wineObject, WineDTO.class))
                    .collect(Collectors.toList())
        );

        List<String> varieties = this.varietyService.getRandomVarieties(5L).stream().map(VarietyDTO::getVariety).toList();
        List<String> wineries = this.wineryService.getRandomWineries(5L).stream().map(WineryDTO::getWinery).toList();

        return new FindWineRes(winess, varieties, wineries);
    }

    @Override
    public void saveFavouriteWine(SaveWineReq wineToSave) {
        this.savedWineRepository.save(new SavedWineEntity(wineToSave.userId, wineToSave.getWine()));
    }

    @Override
    public List<WineDTO> getFavouriteWinesPage(int pageNumber, String userId) {
        Pageable pageableRequest = PageRequest.of(pageNumber, 3, Sort.Direction.DESC);
        Page<SavedWineEntity> savedWineEntities = this.savedWineRepository.findAllByUserIdOrderById(pageableRequest, userId);
        return savedWineEntities
                .stream()
                .map(wineObject -> modelMapper.map(wineObject, WineDTO.class))
                .toList();
    }

    @Override
    public List<WineDTO> getAllFavourites(String userId) {
        List<SavedWineEntity> savedWineEntities = this.savedWineRepository.findAllByUserIdOrderById(userId);
        return savedWineEntities
                .stream()
                .map(wineObject -> modelMapper.map(wineObject.getWine(), WineDTO.class))
                .toList();
    }
}
