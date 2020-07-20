package com.onejava.weatherapp.controller;

import com.onejava.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current/weather")
    public String getWeather() {
        return "The current weather is " + weatherService.getWeather();
    }


}
