package com.example.finewineapi.variety;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VarietyServiceImpl implements VarietyService {

    @Autowired
    private ModelMapper modelMapper;

    private final VarietyRepository varietyRepository;

    public VarietyServiceImpl(VarietyRepository varietyRepository) {
        this.varietyRepository = varietyRepository;
    }

    @Override
    public List<VarietyDTO> getVarieties() {
        return this.varietyRepository.findAll()
                .stream()
                .map(varietyEntity -> modelMapper.map(varietyEntity, VarietyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VarietyDTO> getFiveRandomVarieties() {
        List<VarietyEntity> varieties = this.varietyRepository.findRandomUniqueVarieties();
        return varieties
                .stream()
                .map(varietyEntity -> modelMapper.map(varietyEntity, VarietyDTO.class))
                .collect(Collectors.toList());
    }
}
