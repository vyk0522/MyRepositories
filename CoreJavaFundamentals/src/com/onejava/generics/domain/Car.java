package com.onejava.generics.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
@Getter
public class Car {
    private int id;
    private String name;
    private int price;
}
