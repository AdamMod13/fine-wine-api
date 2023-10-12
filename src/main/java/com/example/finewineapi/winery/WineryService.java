package com.example.finewineapi.winery;

import java.util.List;

public interface WineryService {

    List<WineryDTO> getWineries();

    List<WineryDTO> getRandomWineries(Long size);
}
