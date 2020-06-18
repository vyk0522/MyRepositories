package com.onejava.airportmanagement.docref;

import com.onejava.airportmanagement.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1. This CommandLineRunner should run first. As it populates data into DB.
 */

@Component
@Order(5)
@ConditionalOnProperty(name = "application.docref.repository.runner", havingValue = "enabled")
public class CRUDRepositoryDBRefRunner implements CommandLineRunner {
    private FlightRepository flightRepository;
    private AirportRepository airportRepository;
    private MongoTemplate mongoTemplate;

    public CRUDRepositoryDBRefRunner(FlightRepository flightRepository, AirportRepository airportRepository, MongoTemplate mongoTemplate) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        dropCollections();
        insertAllDocuments();
        updateAirportNameByID("1d1aab22-670b-48cb-a027-721e2055731f");

        System.out.println("DatabaseRepoSeederRunner: Removed existing airports and flight collections and new documents are inserted...");
    }

    private void updateAirportNameByID(String id) {
        Airport rome = this.airportRepository.findById("1d1aab22-670b-48cb-a027-721e2055731f").get();
        rome.setName("Leonardo da Vinci (Fiumicino)");
        this.airportRepository.save(rome);

        List<Flight> flights = this.flightRepository.findAll();
        FlightPrinter.printFlight(flights, "-> AFTER UPDATE TO ROME AIRPORT");
    }


    /*
    This method inserts Flight documents in bulk.
     */
    private void insertAllDocuments() {
        List<Airport> airports = new ArrayList<>();
        List<Flight> flights = getFlights(airports);
        // airportRepository.insert(airports);  // We can comment this if we have implemented cascading
        flightRepository.insert(flights);  // It does not insert referenced airport documents into airports collection. We need to explicitly insert that using above code.
        FlightPrinter.printFlight(flights);
    }

    /*
    This method is to drop Airport and Flight collections
     */
    private void dropCollections() {
        mongoTemplate.dropCollection(Airport.class);
        mongoTemplate.dropCollection(Flight.class);
    }

    /*
    This method creates list of FlightInformation
     */
    private List<Flight> getFlights(List<Airport> airports) {
        // Airports
        Airport rome = new Airport("1d1aab22-670b-48cb-a027-721e2055731f", "Leonardo da Vinci", "Rome", 42995119);
        Airport paris = new Airport("d04a8c26-7527-407c-81ef-680e5de34cea", "Charles de Gaulle", "Paris", 72229723);
        Airport copenhagen = new Airport("7ed990d2-6471-485d-931e-c77729dc0f25", "Copenhagen Airport", "Copenhagen", 30298531);

        airports.addAll(Arrays.asList(rome, paris, copenhagen));

        // Flight data
        Flight flightOne = new Flight();
        flightOne.setId("b8b50563-ca90-4afc-9d43-b674892a525c");
        flightOne.setDelayed(false);
        flightOne.setDeparture(rome);
        flightOne.setDestination(paris);
        flightOne.setDepartureDate(LocalDate.of(2019, 3, 12));
        flightOne.setType(FlightType.International);
        flightOne.setDurationMin(80);
        flightOne.setAircraft(new Aircraft("737", 180));

        Flight flightTwo = new Flight();
        flightTwo.setId("c0725fbb-eebb-4aae-8b41-3887793d0c50");
        flightTwo.setDelayed(false);
        flightTwo.setDeparture(paris);
        flightTwo.setDestination(copenhagen);
        flightTwo.setDepartureDate(LocalDate.of(2019, 5, 11));
        flightTwo.setType(FlightType.International);
        flightTwo.setDurationMin(600);
        flightTwo.setAircraft(new Aircraft("747", 300));

        // Seed
        return Arrays.asList(flightOne, flightTwo);
    }
}
