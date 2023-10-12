package com.example.finewineapi.variety;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/variety")
public class VarietyController {

    private final VarietyService varietyService;

    public VarietyController(VarietyService varietyService) {
        this.varietyService = varietyService;
    }

    @GetMapping("/all")
    public List<VarietyDTO> getVarieties() {
        return this.varietyService.getVarieties();
    }
}
