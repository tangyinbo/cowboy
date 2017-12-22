package com.cowboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sun.misc.BASE64Encoder;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class CowobyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CowobyApplication.class, args);
    }
}
