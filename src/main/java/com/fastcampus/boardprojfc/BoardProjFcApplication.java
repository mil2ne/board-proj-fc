package com.fastcampus.boardprojfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BoardProjFcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardProjFcApplication.class, args);
    }

}
