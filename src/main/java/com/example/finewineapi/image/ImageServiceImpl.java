package com.example.finewineapi.image;

import com.example.finewineapi.wine.WineDTO;
import com.example.finewineapi.wine.WineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private static final String UPLOAD_DIR = "src/main/python/wine-etiquette-recognizer/img/to-read/";

    private WineRepository wineRepository;

    private ModelMapper modelMapper;

    @Override
    public WineDTO getWineByEtiquette(MultipartFile image) throws IOException {
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            String fileName = image.getOriginalFilename();

            Path targetPath = Paths.get(UPLOAD_DIR + fileName);

            Files.write(targetPath, image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to upload image");
        }

        List<String> defaultParams = Arrays.asList("python3", "src/main/python/wine-etiquette-recognizer/main.py", "--read");

        // Run etiquette reader
        ProcessBuilder processBuilder = new ProcessBuilder(defaultParams);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        String pythonOutput = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            pythonOutput = line;
        }

        return modelMapper.map(wineRepository.findById(Long.parseLong(pythonOutput)), WineDTO.class);
    }
}
