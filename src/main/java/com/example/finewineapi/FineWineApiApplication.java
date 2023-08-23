package com.example.finewineapi;

import com.example.finewineapi.wine.WineRepository;
import com.example.finewineapi.wine.WineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication()
public class FineWineApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FineWineApiApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    CommandLineRunner commandLineRunner(WineService wineService, WineRepository wineRepository) {
//        return args -> {
//            wineRepository.findById(1L)
//                    .ifPresent(s -> {
//                        System.out.println(s.getCountry());
//                    });
////            wineService.getWines();
//        };
//    }
}
