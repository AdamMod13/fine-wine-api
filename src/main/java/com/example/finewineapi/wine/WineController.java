package com.example.finewineapi.wine;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/wine")
public class WineController {

    private final WineServiceImpl wineService;

    public WineController(WineServiceImpl wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/all")
    public List<WineDTO> getWines() {
        return this.wineService.getWines();
    }
}
