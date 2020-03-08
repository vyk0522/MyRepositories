package com.onejava.microservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * A. Create and Annotate the class with @Component and @ConfigurationProperties("limits-service")
 * B. Both setters and getters with proper signature should be there. Else it returns default value
 * EX: For limits-service.maximum key, setMaximum and getMaximum methods should be there
 * 
 */
@Component
@ConfigurationProperties("limits-service")
public class PropertiesConfiguration {
	private int min;
	private int max;
	
	public void setMaximum(int max) {
		this.max = max;
	}
	public void setMinimum(int minimum) {
		this.min = minimum;
	}
	public int getMinimum() {
		return min;
	}
	public int getMaximum() {
		return max;
	}
	
	

}
