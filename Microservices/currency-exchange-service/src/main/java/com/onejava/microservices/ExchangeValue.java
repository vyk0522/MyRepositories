package com.onejava.microservices;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * 1. Fields
 * 2. At least one getter should be there. Else No converter Found 500 Error
 * 3. Constructor with fields, to set hard coded values
 * 4. Added port and getter and setters to know which instance is serving the request, if multiple instances are running
 * 5. Make ExchangeValue as Entity class
 * 
 */
@Entity
public class ExchangeValue {
	@Id
	private Long id;
	
	@Column(name = "currency_from")
	private String from;
	
	@Column(name = "currency_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	
	private int port;
	
	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public Long getId() {
		return id;
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}


	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	
	


	public ExchangeValue() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}	

}
