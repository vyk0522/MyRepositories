package com.onejava.airportmanagement.dbconverters;

import com.onejava.airportmanagement.domain.Aircraft;
import org.springframework.core.convert.converter.Converter;

/*
1. It's Read converter. It reads String from DB and converts it to Aircraft object.
2. Class should implement Converter. First parameter is from and second parameter is to.
 */
public class AircraftDbReadConverter implements Converter<String, Aircraft> {
    @Override
    public Aircraft convert(String s) {
        if(s == null){
            return null;
        }

        String[] parts = s.split("/");
        Aircraft aircraft = new Aircraft(parts[0], Integer.parseInt(parts[1]));
        return aircraft;
    }
}
