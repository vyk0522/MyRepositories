package com.onejava.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * 1. Set application name and server port
 * 2. This service talks to currency-exchange-service to get id, conversionMultiple and port
 * 3. It uses Feign to invoke other micro service
 * 
 */

@SpringBootApplication
@EnableFeignClients("com.onejava.microservices")  // Package where it needs to scan for clients
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}
