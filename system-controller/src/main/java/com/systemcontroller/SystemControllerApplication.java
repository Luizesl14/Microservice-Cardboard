package com.systemcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SystemControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemControllerApplication.class, args);
    }

}
