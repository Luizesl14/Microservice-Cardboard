package com.systemorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableCaching
@SpringBootApplication
@EnableEurekaClient
public class SystemOrderServiceApplication {

    public static void main(String[] args) {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
        SpringApplication.run(SystemOrderServiceApplication.class, args);
    }

}
