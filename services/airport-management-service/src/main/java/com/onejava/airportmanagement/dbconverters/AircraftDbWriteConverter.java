package com.onejava.airportmanagement.dbconverters;

import com.onejava.airportmanagement.domain.Aircraft;
import org.springframework.core.convert.converter.Converter;

/*
1. It's write converter. It converts Aircraft object into string and writes string into DB.
In DB, String will be persisted instead of Aircraft Object.
2. Class should implement Converter. First parameter is from and second parameter is to.
 */
public class AircraftDbWriteConverter implements Converter<Aircraft, String> {

    @Override
    public String convert(Aircraft aircraft) {
        return aircraft.getModel() + "/" + aircraft.getNbSeats();
    }
}
