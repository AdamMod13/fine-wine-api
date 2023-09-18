package com.example.finewineapi.wine;

import com.example.finewineapi.models.WineRecommendationReq;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class WineServiceImpl implements WineService {

    @Autowired
    private ModelMapper modelMapper;

    private final WineRepository wineRepository;

    public WineServiceImpl(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
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
        WineRecommendationReq pythonWineRecommendationReq = wineRecommendationReq;
        ProcessBuilder processBuilder = new ProcessBuilder(
                "python",
                "src/main/java/com/example/finewineapi/recommending_system.py",
                pythonWineRecommendationReq.getCountry(),
                pythonWineRecommendationReq.getWineColor(),
                pythonWineRecommendationReq.getVariety(),
                pythonWineRecommendationReq.getWinery(),
                pythonWineRecommendationReq.getPoints().toString(),
                pythonWineRecommendationReq.getPrice().toString()
        );
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();
        System.out.println("Script exited with code: " + exitCode);
        return null;
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
}
