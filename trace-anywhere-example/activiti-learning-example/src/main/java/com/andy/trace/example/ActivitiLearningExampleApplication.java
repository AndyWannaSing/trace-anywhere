package com.andy.trace.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.andy.trace.example")
public class ActivitiLearningExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiLearningExampleApplication.class, args);
    }

}
