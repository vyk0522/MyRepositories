package com.onejava.airportmanagement.docref;

import com.onejava.airportmanagement.domain.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {
    @Query("{'aircraft.nbSeats': {$gte: ?0}}")
    List<Flight> findByMinAircraftNbSeatsAndDest(int i);
}
