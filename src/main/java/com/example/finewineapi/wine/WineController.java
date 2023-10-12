package com.example.finewineapi.wine;

import com.example.finewineapi.models.FindWineReq;
import com.example.finewineapi.models.FindWineRes;
import com.example.finewineapi.models.WineRecommendationReq;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/wine")
public class WineController {

    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/all")
    public List<WineDTO> getWines() {
        return this.wineService.getWines();
    }

    @GetMapping("/get-best-random-wines")
    public List<WineDTO> getBestRandomWines() {
        return this.wineService.getBestRandomWines();
    }

    @PostMapping("/get-recommendations")
    public List<WineDTO> getRecommendations(@RequestBody WineRecommendationReq wineRecommendationReq) throws IOException, InterruptedException {
        return this.wineService.getRecommendations(wineRecommendationReq);
    }

    @PostMapping("/save-current-recommendations")
    public void saveCurrentRecommendations(@RequestBody List<WineDTO> currentRecommendations) {
        this.wineService.saveCurrentRecommendations(currentRecommendations);
    }

    @GetMapping("/get-current-recommendations")
    public List<WineDTO> getCurrentRecommendations() {
        return this.wineService.getCurrentRecommendations();
    }

    @PostMapping("/get-wine-page-with-filters/{pageNumber}")
    public FindWineRes getAllWines(@PathVariable(name = "pageNumber") int pageNumber, @RequestBody FindWineReq findWineReq) {
        return this.wineService.getWinePageWithFilters(pageNumber, findWineReq);
    }
}
