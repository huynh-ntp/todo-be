package com.huynhntp.todobe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TodoBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoBeApplication.class, args);
    }

}
