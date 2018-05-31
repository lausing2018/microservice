package com.activemessure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import hello.GreetingController;

@SpringBootApplication
@ComponentScan("hello,com.activemessure")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
