package com.onejava.microservices.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
    @Autowired
    private EurekaClient client;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/")
    public String callService() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("application-service", false);
        String baseUrl = instanceInfo.getHomePageUrl();
        ResponseEntity<String> response =
                restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
        return response.getBody();
    }
}
