package com.example.finewineapi.wine;

import com.example.finewineapi.models.FindWineReq;
import com.example.finewineapi.models.FindWineRes;
import com.example.finewineapi.models.WishlistWineReq;
import com.example.finewineapi.models.WineRecommendationReq;

import java.io.IOException;
import java.util.List;

public interface WineService {

    List<WineDTO> getWines();

    List<WineDTO> getBestRandomWines();

    List<WineDTO> getRecommendations(WineRecommendationReq wineRecommendationReq) throws IOException, InterruptedException;

    void saveCurrentRecommendations(List<WineDTO> currentRecommendations);

    List<WineDTO> getCurrentRecommendations();

    FindWineRes getWinePageWithFilters(int pageNumber, FindWineReq findWineReq);

    List<WineDTO> getFavouriteWinesPage(int pageNumber, String userId);

    List<WineDTO> getAllFavourites(String userId);

    void saveFavouriteWine(WishlistWineReq wineToSave);

    void deleteFavouriteWine(WishlistWineReq wineToDelete);
}
