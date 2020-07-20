package com.onejava.timeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {
    @Value("${server.port}")
    private int port;

    @GetMapping("/")
    public String getTime() {
        return "The current time is " + new Date().toString()
                + "(answered by service running on " + port + ")";
    }
}
