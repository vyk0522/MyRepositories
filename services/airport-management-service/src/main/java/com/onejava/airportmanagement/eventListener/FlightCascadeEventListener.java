package com.onejava.airportmanagement.eventListener;

import com.onejava.airportmanagement.domain.Airport;
import com.onejava.airportmanagement.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class FlightCascadeEventListener extends AbstractMongoEventListener<Flight> {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Flight> event) {
        Flight doc = event.getSource();

        if(doc.getDeparture() != null){
            Airport departure = doc.getDeparture();
            mongoTemplate.save(departure);
        }

        if(doc.getDestination() != null){
            Airport destination = doc.getDestination();
            mongoTemplate.save(destination);
        }
    }
}
