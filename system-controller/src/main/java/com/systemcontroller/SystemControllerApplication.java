package com.systemcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
public class SystemControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemControllerApplication.class, args);
    }

}
