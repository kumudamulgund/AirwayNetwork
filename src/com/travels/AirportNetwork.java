package com.travels;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class AirportNetwork {

    private static final Set<String> airports = new HashSet<String>();
    private static final TreeMap<String, Flight> flightDetails = new TreeMap<String, Flight>();

    public AirportNetwork() {
        createAirports();
        createFlightDetails();
    }

    private void createAirports() {
        String[] airports = { "Bengaluru", "Mumbai", "Kolkata", "Chennai", "Delhi" };
        for (String airport : airports)
            this.registerAirports(airport);
    }

    private void createFlightDetails() {
        flightDetails.put("Bengaluru", new Flight(10000, 2000, "Delhi"));
        flightDetails.put("Delhi", new Flight(8000, 1500, "Kolkata"));
        flightDetails.put("Kolkata", new Flight(9000, 1800, "Chennai"));
        flightDetails.put("Chennai", new Flight(15000, 2200, "Delhi"));
        flightDetails.put("Chennai", new Flight(3000, 400, "Bengaluru"));
    }

    public static boolean doesAirportExist(final String airportName) {
        if (!airports.contains(airportName)) return false;
        return true;
    }

    public void registerAirports(final String name) {
        if (doesAirportExist(name)) throw new RuntimeException(name + " Already present");
        airports.add(name);
    }

    public void registerFlights(final String source, final Flight flight) {
        if (!doesAirportExist(source)) throw new RuntimeException("Airport does not exist");
        flightDetails.put(source, flight);
    }

}