package com.onejava.airportmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

//@Configuration
public class Config extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "airportmanagement";
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }}