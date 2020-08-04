package com.onejava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/*
@Getter is mandatory
@AllArgsConstructor is mandatory
 */
@Getter
@AllArgsConstructor
@ToString
public class UsageCostResponse {
    private String type;
    private String offer;
    private BigDecimal conversionMultiple;
}
