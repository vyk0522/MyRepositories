package com.onejava.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	PropertiesConfiguration propertiesConfiguration;
	
	// http://localhost:8080/limits
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(propertiesConfiguration.getMinimum(), propertiesConfiguration.getMaximum());
	}
	
	// http://localhost:8080/fault-tolerance
	@GetMapping("/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallBackRetrieveConfiguration")
	public LimitConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}
	
	public LimitConfiguration fallBackRetrieveConfiguration() {
		return new LimitConfiguration(0,0);
	}

}
