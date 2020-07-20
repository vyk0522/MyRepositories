package com.onejava.microservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${application.service.instance.name}")
    private String instance;

    @GetMapping("/")
    public String message(){
        return "Hello From " + instance;
    }
}
