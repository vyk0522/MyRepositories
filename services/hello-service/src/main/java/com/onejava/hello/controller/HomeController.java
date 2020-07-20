package com.onejava.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String sayHello(@RequestHeader("x-location") String location) {
        return "Hello from " + location + "!!";
    }

    @GetMapping("/{user}")
    public String sayUserHello(@PathVariable String user) {
        return "Hello " + user + "!!" ;
    }

}
