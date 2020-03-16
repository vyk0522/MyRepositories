package com.onejava.microservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * A. Create and Annotate the class with @Component and @ConfigurationProperties("limits-service")
 * B. Setters with proper signature should be there. Else it doesn't set the value
 * EX: limits-service.minimum=9  -- setMinimum() method name should be there
 * 
 */
@Component
@ConfigurationProperties("limits-service")
public class PropertiesConfiguration {
	private int minimum;
	private int maximum;
	
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMinimum() {
		return minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	
	

}
