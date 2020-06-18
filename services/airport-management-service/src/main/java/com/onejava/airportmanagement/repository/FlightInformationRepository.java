package com.onejava.airportmanagement.repository;

import com.onejava.airportmanagement.domain.FlightInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightInformationRepository extends MongoRepository<FlightInformation, String> {
    List<FlightInformation> findByDurationMinBetween(int min, int max);
    List<FlightInformation> findByTypeLike(String wildCard);
    List<FlightInformation> findByIsDelayedTrue();

    List<FlightInformation> findByIsDelayedTrueAndDepartureCity(String dep);
    List<FlightInformation> findByIsDelayedFalseOrDepartureCityLike(String wildCard);

    @Query("{'aircraft.nbSeats': {$gte: ?0}, destination:?1 }")
    List<FlightInformation> findByMinAircraftNbSeatsAndDest(int i, String destination);
}
