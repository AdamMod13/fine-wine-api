package com.example.finewineapi.image;

import com.example.finewineapi.wine.WineDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    WineDTO getWineByEtiquette(MultipartFile image) throws IOException;
}
