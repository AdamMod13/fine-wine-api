package com.example.finewineapi.wine;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Random rand = new Random();
        bestRandomWines.add(this.wineRepository.findById(rand.nextLong(
                this.wineRepository.countByWineColorAndPointsGreaterThan("red", 80L)
        )).orElse(null));
        bestRandomWines.add(this.wineRepository.findById(rand.nextLong(
                this.wineRepository.countByWineColorAndPointsGreaterThan("rose", 80L)
        )).orElse(null));
        bestRandomWines.add(this.wineRepository.findById(rand.nextLong(
                this.wineRepository.countByWineColorAndPointsGreaterThan("white", 80L)
        )).orElse(null));
        bestRandomWines.add(this.wineRepository.findById(rand.nextLong(
                this.wineRepository.countByWineColorAndPointsGreaterThan("sparkling", 80L)
        )).orElse(null));
        return bestRandomWines
                .stream()
                .map(wineEntity -> modelMapper.map(wineEntity, WineDTO.class))
                .collect(Collectors.toList());
    }
}
