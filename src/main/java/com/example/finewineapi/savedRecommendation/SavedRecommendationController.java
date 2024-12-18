package com.example.finewineapi.savedRecommendation;

import com.example.finewineapi.models.SaveRecommendationReq;
import com.example.finewineapi.recommendation.RecommendationDTO;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/recommendations")
public class SavedRecommendationController {

    private final SavedRecommendationService savedRecommendationService;

    public SavedRecommendationController(SavedRecommendationService savedRecommendationService) {
        this.savedRecommendationService = savedRecommendationService;
    }

    @PostMapping("/save-recommendation")
    public void saveRecommendation(@RequestBody SaveRecommendationReq request) {
        this.savedRecommendationService.saveRecommendation(new HashSet<>(request.getWineIds()), request.getUserId());
    }

    @GetMapping("/get-all-user-recommendations/{userId}")
    public List<RecommendationDTO> getUserRecommendations(@PathVariable("userId") String userId) {
        return savedRecommendationService.getUserRecommendations(userId);
    }
}
