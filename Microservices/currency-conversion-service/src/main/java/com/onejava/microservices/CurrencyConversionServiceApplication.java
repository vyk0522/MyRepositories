package com.onejava.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

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
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
