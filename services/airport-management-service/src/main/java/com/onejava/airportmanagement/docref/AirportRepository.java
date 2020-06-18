package com.onejava.airportmanagement.docref;

import com.onejava.airportmanagement.domain.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {
}
