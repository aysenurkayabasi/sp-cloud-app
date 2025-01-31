package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApigwApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApigwApplication.class, args);
    }
}
