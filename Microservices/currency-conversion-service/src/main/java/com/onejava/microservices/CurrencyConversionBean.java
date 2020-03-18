package com.onejava.microservices;

import java.math.BigDecimal;

/*
 * 1. Fields
 * 2. At least one getter should be there. Else No converter Found 500 Error
 * 3. Constructor with fields, to set hard coded values
 * 
 */
public class CurrencyConversionBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalAmount;
	private int port;
	
	// It is must else Cannot construct instance 500 error 
	public CurrencyConversionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public int getPort() {
		return port;
	}
	
	
	
	

}
