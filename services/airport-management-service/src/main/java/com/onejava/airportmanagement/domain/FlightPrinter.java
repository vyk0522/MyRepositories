package com.onejava.airportmanagement.domain;

import java.util.List;

public class FlightPrinter {
    public static void print(List<FlightInformation> flights){
        String header = String.format("%-12s %-12s %-8s %-13s %-9s %-8s %-8s %s","DEP","DST","DURATION","DATE","DELAYED","A. TYPE", "A. SEATS", "DESC");
        System.out.println("-----------------------------------");
        System.out.println("\n"+header);
        for (FlightInformation flight: flights) {
            String data = String.format("%-12s %-12s %-8s %-13s %-9s %-8s %-8s %s",
                    flight.getDepartureCity(),
                    flight.getDestinationCity(),
                    flight.getDurationMin(),
                    flight.getDepartureDate(),
                    flight.isDelayed(),
                    flight.getAircraft().getModel(),
                    flight.getAircraft().getNbSeats(),
                    flight.getDescription());
            System.out.println(data);
        }
        System.out.println("-----------------------------------");
    }

    public static void printFlight(List<Flight> flights){
        System.out.println("-----------------------------------");
        String header = String.format("%-30s %-30s %-8s %-13s %-9s %-8s",
                "DEP","DST","DURATION","DATE","DELAYED","A. TYPE");
        System.out.println(header);
        for (Flight f: flights) {
            String data = String.format("%-30s %-30s %-8s %-13s %-9s %-8s",
                    f.getDeparture().getName(),
                    f.getDestination().getName(),
                    f.getDurationMin(),
                    f.getDepartureDate(),
                    f.isDelayed(),
                    f.getAircraft().getModel());
            System.out.println(data);
        }
        System.out.println("-----------------------------------");
    }

    public static void printFlight(List<Flight> flights, String message){
        System.out.println("-----------------------------------");
        String header = String.format("%-30s %-30s %-8s %-13s %-9s %-8s",
                "DEP","DST","DURATION","DATE","DELAYED","A. TYPE");
        System.out.println(message);
        System.out.println(header);
        for (Flight f: flights) {
            String data = String.format("%-30s %-30s %-8s %-13s %-9s %-8s",
                    f.getDeparture().getName(),
                    f.getDestination().getName(),
                    f.getDurationMin(),
                    f.getDepartureDate(),
                    f.isDelayed(),
                    f.getAircraft().getModel());
            System.out.println(data);
        }
        System.out.println("-----------------------------------");
    }

    public static void print(List<FlightInformation> flights, String message){
        String header = String.format("%-12s %-12s %-8s %-13s %-9s %-8s %-8s %s","DEP","DST","DURATION","DATE","DELAYED","A. TYPE", "A. SEATS", "DESC");
        System.out.println("-----------------------------------");
        System.out.println(message);
        System.out.println("\n"+header);
        for (FlightInformation flight: flights) {
            String data = String.format("%-12s %-12s %-8s %-13s %-9s %-8s %-8s %s",
                    flight.getDepartureCity(),
                    flight.getDestinationCity(),
                    flight.getDurationMin(),
                    flight.getDepartureDate(),
                    flight.isDelayed(),
                    flight.getAircraft().getModel(),
                    flight.getAircraft().getNbSeats(),
                    flight.getDescription());
            System.out.println(data);
        }
        System.out.println("-----------------------------------");
    }

    public static void print(String message){
        System.out.println("-----------------------------------");
        System.out.println(message);
        System.out.println("-----------------------------------");
    }

}
