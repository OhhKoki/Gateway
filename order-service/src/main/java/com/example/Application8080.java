package com.example;

import com.example.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(defaultConfiguration = FeignConfig.class)
@SpringBootApplication
public class Application8080 {

    public static void main(String[] args) {
        SpringApplication.run(Application8080.class, args);
    }

}
