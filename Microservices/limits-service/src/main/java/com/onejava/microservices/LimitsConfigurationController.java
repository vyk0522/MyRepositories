package com.onejava.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	PropertiesConfiguration propertiesConfiguration;
	
	// http://localhost:8080/limits
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(propertiesConfiguration.getMinimum(), propertiesConfiguration.getMaximum());
	}

}
