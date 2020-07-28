package com.onejava.configclient.controller;

import com.onejava.configclient.config.LimitConfiguration;
import com.onejava.configclient.config.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HomeController {
    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Value("${common.application.property1}")
    private String commonProp;

    // http://localhost:8084/limits
    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {
        LimitConfiguration limitConfiguration = new LimitConfiguration(propertiesConfiguration.getMinimum(), propertiesConfiguration.getMaximum());
        limitConfiguration.setCommonProperty(commonProp);
        return limitConfiguration;
    }

}

