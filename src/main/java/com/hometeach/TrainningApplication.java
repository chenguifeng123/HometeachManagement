package com.hometeach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class TrainningApplication {
    public static void main(String[] args){
        SpringApplication.run(TrainningApplication.class, args);
    }
}
