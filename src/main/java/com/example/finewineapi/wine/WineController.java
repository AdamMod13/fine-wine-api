package com.example.finewineapi.wine;

import com.example.finewineapi.image.ImageService;
import com.example.finewineapi.models.FindWineReq;
import com.example.finewineapi.models.FindWineRes;
import com.example.finewineapi.models.WishlistWineReq;
import com.example.finewineapi.models.WineRecommendationReq;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/wine")
public class WineController {

    private final WineService wineService;
    private final ImageService imageService;

    public WineController(WineService wineService, ImageService imageService) {
        this.imageService = imageService;
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
    public List<WineDTO> getRecommendations(@RequestBody WineRecommendationReq wineRecommendationReq)
            throws IOException, InterruptedException {
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

    @PostMapping("/save-favourite-wine")
    public void saveFavouriteWine(@RequestBody WishlistWineReq wineToSave) {
         this.wineService.saveFavouriteWine(wineToSave);
    }

    @PostMapping("/delete-favourite-wine")
    public void deleteFavouriteWine(@RequestBody WishlistWineReq wineToSave) {
        this.wineService.deleteFavouriteWine(wineToSave);
    }

    @PostMapping("/get-favourites-wine-page/{pageNumber}")
    public List<WineDTO> getFavouriteWinesPage(@PathVariable(name = "pageNumber") int pageNumber, @RequestBody String userId) {
        return this.wineService.getFavouriteWinesPage(pageNumber, userId);
    }

    @PostMapping("/get-all-favourites")
    public List<WineDTO> getFavouriteWinesPage(@RequestBody String userId) {
        return this.wineService.getAllFavourites(userId);
    }

    @PostMapping("/get-wine-by-filters")
    public List<WineDTO> getFavouriteWinesPage(@RequestBody FindWineReq findWineReq) {
        return this.wineService.getWinesByFilters(findWineReq);
    }

    @PostMapping("/get-wine-by-etiquette")
    public WineDTO getWineByEtiquette(@RequestParam("image") MultipartFile image) throws IOException {
        return this.imageService.getWineByEtiquette(image);
    }
}
