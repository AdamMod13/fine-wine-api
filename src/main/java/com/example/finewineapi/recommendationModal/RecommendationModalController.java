package com.example.finewineapi.recommendationModal;

import com.example.finewineapi.models.FilterWineryOrVarietyReq;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/recommendation-modal")
public class RecommendationModalController {

    private final RecommendationModalService recommendationModalService;

    public RecommendationModalController(RecommendationModalService recommendationModalService) {
        this.recommendationModalService = recommendationModalService;
    }

    @GetMapping("/get-filters")
    public RecommendationModalDTO getFilters() {
        return this.recommendationModalService.getFilters();
    }

    @PostMapping("/search-winery-or-variety")
    public RecommendationModalDTO getSpecificFilters(@RequestBody FilterWineryOrVarietyReq specificFiltersReq) {
        if (specificFiltersReq.getValue().isEmpty()) {
            return this.recommendationModalService.getFilters();
        }
        return this.recommendationModalService.getSpecificFilters(specificFiltersReq);
    }
}
