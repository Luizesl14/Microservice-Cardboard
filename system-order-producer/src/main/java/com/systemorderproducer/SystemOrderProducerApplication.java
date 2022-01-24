package com.systemorderproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SystemOrderProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemOrderProducerApplication.class, args);
    }

}
