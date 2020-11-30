package com.cesar.demo.application;

import com.cesar.demo.application.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(AppProperties.class)
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class, args); }

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }
}
