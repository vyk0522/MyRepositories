package com.onejava.airportmanagement.repository;

import com.onejava.airportmanagement.domain.FlightInformation;
import com.onejava.airportmanagement.domain.FlightPrinter;
import com.onejava.airportmanagement.repository.FlightInformationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/*
This component will be the main entry point for
our use cases. It should get executed after the seeding
process
 */

@Service
@Order(4)
@ConditionalOnProperty(name = "application.repository.runner", havingValue = "enabled")
public class CRUDRepositoryApplicationRunner implements CommandLineRunner {
    private FlightInformationRepository repository;

    public CRUDRepositoryApplicationRunner(FlightInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        long count = repository.count();
        FlightPrinter.print("All Flights Count: " + count);

        List<FlightInformation> allDocuments = repository.findAll(Sort.by("type").ascending().and(Sort.by("departureCity").descending()));
        FlightPrinter.print(allDocuments, "All Flights sorted by type and departureCity: ");

        FlightInformation flight = repository.findById("4d23fd8b-47a7-45f8-958c-94d0e21488b2").get();
        FlightPrinter.print(Arrays.asList(flight), "Flight Whose ID: 4d23fd8b-47a7-45f8-958c-94d0e21488b2 ");

        boolean isFlightExists = repository.existsById("4d23fd8b-47a7-45f8-958c-94d0e21488b2");
        FlightPrinter.print("isFlightExists: " + isFlightExists);

        List<FlightInformation> byDurationMinBetween = repository.findByDurationMinBetween(50, 400);
        FlightPrinter.print(byDurationMinBetween, "Flights between Two duration: ");

        List<FlightInformation> byTypeLike = repository.findByTypeLike("Int");
        FlightPrinter.print(byTypeLike, "Flights Whose Type contains: ");

        List<FlightInformation> byIsDelayedTrue = repository.findByIsDelayedTrue();
        FlightPrinter.print(byIsDelayedTrue, "Delayed flights: ");

        List<FlightInformation> byIsDelayedTrueAndDepartureCity = repository.findByIsDelayedTrueAndDepartureCity("Bruxelles");
        FlightPrinter.print(byIsDelayedTrueAndDepartureCity, "Delayed flights to Bruxelles: ");

        List<FlightInformation> byIsDelayedFalseAndDepartureCityLike = repository.findByIsDelayedFalseOrDepartureCityLike("Mad");
        FlightPrinter.print(byIsDelayedFalseAndDepartureCityLike, "On time flights and dest which has Mad in it : ");

        repository.deleteById("4d23fd8b-47a7-45f8-958c-94d0e21488b2");
        FlightPrinter.print("Flight whose ID 4d23fd8b-47a7-45f8-958c-94d0e21488b2 is deleted");

        updateFlight("51cd0e4f-1e42-4e48-a961-64f889eee6b5", 30);

        List<FlightInformation> flights = repository.findByMinAircraftNbSeatsAndDest(200, "Copenhagen");
        FlightPrinter.print(flights, "Flights gte minimum number of seats: 200 and destination:  Copenhagen ");
    }

    private void updateFlight(String id, int duration) {
        FlightInformation flight = repository.findById(id).get();
        flight.setDurationMin(flight.getDurationMin() + duration);
        flight.setDelayed(true);
        repository.save(flight);
        FlightPrinter.print("Flight whose ID " + id + " is updated: ");
    }
}
