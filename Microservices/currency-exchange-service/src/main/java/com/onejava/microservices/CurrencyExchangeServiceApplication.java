package com.onejava.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * 1. Set application name and server port
 * 2. Expose retrieveExchangeValue end point. Which returns ExchangeValue object. Send server port as well in the object 
 * to know which instance is serving the request 
 * 3. Run multiple instances of this service
 * 4. Configure Data JPA to retrieve values from H2 DB
 */

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}
