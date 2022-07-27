package com.sparta.spring03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Spring03Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring03Application.class, args);
    }

}
