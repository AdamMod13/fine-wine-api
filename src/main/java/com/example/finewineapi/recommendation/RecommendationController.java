package com.example.finewineapi.recommendation;

import com.example.finewineapi.models.FilterWineryOrVarietyReq;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/get-filters")
    public RecommendationDTO getFilters() {
        return this.recommendationService.getFilters();
    }

    @PostMapping("/search-winery-or-variety")
    public RecommendationDTO getSpecificFilters(@RequestBody FilterWineryOrVarietyReq specificFiltersReq) {
        if (specificFiltersReq.getValue().isEmpty()) {
            return this.recommendationService.getFilters();
        }
        return this.recommendationService.getSpecificFilters(specificFiltersReq);
    }
}
