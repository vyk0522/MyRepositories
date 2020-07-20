package com.onejava.configclient.config;

/*
 * 1. Fields
 * 2. Getters are must // Else No converter found for return value of type error
 * 3. Constructor with fields
 */
public class LimitConfiguration {
    private int minimum;
    private int maximum;
    private String commonProperty;

    public String getCommonProperty() {
        return commonProperty;
    }

    public void setCommonProperty(String commonProperty) {
        this.commonProperty = commonProperty;
    }



    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public LimitConfiguration(int minimum, int maximum) {
        super();
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
