package com.example.backendplanning;

import com.example.backendplanning.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class BackendPlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendPlanningApplication.class, args);
    }

}
