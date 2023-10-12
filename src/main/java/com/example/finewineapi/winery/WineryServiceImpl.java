package com.example.finewineapi.winery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WineryServiceImpl implements WineryService {

    @Autowired
    private ModelMapper modelMapper;

    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public List<WineryDTO> getWineries() {
        return this.wineryRepository.findAll()
                .stream()
                .map(wineryEntity -> modelMapper.map(wineryEntity, WineryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<WineryDTO> getFiveRandomWineries() {
        List<WineryEntity> wineries = this.wineryRepository.findRandomUniqueWineries();
        return wineries
                .stream()
                .map(wineryEntity -> modelMapper.map(wineryEntity, WineryDTO.class))
                .collect(Collectors.toList());
    }
}
