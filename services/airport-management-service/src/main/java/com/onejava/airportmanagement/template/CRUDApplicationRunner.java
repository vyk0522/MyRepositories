package com.onejava.airportmanagement.template;

import com.onejava.airportmanagement.domain.FlightInformation;
import com.onejava.airportmanagement.domain.FlightPrinter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/*
1. Find all flights with paging and sorting
2. Find by Flight ID.
3. Count all international flights
4. Find all Flights by departure city.
5. Find all Flights by duration between min and max.
6. Find all Flights delayed at a particular departure city.
7. Find all flights that are on time and relate to a city.
8. Find by aircraft model.
9. Find by free text.
10. Batch Update isDelayed and duration fields for given destination.
11. Batch Delete for FlightsWithDurationLessThanTwoHours.
 */

@Component
@Order(2)
@ConditionalOnProperty(name = "application.template.runner", havingValue = "enabled")
public class CRUDApplicationRunner implements CommandLineRunner {
    private FlightInformationQueries flightInformationQueries;

    public CRUDApplicationRunner(FlightInformationQueries flightInformationQueries) {
        this.flightInformationQueries = flightInformationQueries;
    }

    @Override
    public void run(String... args) {
        List<FlightInformation> allFlightsOrdered = flightInformationQueries.findAllFlights("departure", 0, 3);
        FlightPrinter.print(allFlightsOrdered, "All Flights sorted by departure and page size 3: ");

        FlightInformation singleById = flightInformationQueries.findSingleById("4d23fd8b-47a7-45f8-958c-94d0e21488b2");
        FlightPrinter.print(Arrays.asList(singleById), "Flight Whose ID: 4d23fd8b-47a7-45f8-958c-94d0e21488b2:  ");

        long count = flightInformationQueries.countInternational();
        FlightPrinter.print("International Flights Count:  " + count);

        List<FlightInformation> byDeparture = flightInformationQueries.findByDeparture("New York");
        FlightPrinter.print(byDeparture, "All Flights whose departure is New York: ");

        List<FlightInformation> byDurationBetween = flightInformationQueries.findByDurationBetween(60, 120);
        FlightPrinter.print(byDurationBetween, "All Flights whose duration between: ");

        List<FlightInformation> delayedAtDeparture = flightInformationQueries.findDelayedAtDeparture("Madrid");
        FlightPrinter.print(delayedAtDeparture, "All Flights delayed at departure: ");

        List<FlightInformation> relatedToCityAndNotDelayed = flightInformationQueries.findRelatedToCityAndNotDelayed("New York");
        FlightPrinter.print(relatedToCityAndNotDelayed, "All Flights relatedToCityAndNotDelayed New York: ");

        List<FlightInformation> byAircraft = flightInformationQueries.findByAircraft("A319");
        FlightPrinter.print(byAircraft, "All Flights by sub document field: ");

        List<FlightInformation> byFreeText = flightInformationQueries.findByFreeText("rome");
        FlightPrinter.print(byFreeText, "All Flights by free text: ");

        flightInformationQueries.updateAllFlightsToDestinationAsDelayed("Copenhagen");
        flightInformationQueries.removeFlightsWithDurationLessThanTwoHours();
    }
}