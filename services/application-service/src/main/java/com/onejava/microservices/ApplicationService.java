package com.onejava.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationService {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationService.class, args);
	}

}