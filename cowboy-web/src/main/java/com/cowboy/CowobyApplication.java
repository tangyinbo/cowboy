package com.cowboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CowobyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CowobyApplication.class, args);
    }
}
