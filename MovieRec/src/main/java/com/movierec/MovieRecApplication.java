package com.movierec;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieRecApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MovieRecApplication.class, args);
    }

}
