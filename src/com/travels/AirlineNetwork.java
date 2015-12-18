package com.travels;

import java.util.ArrayList;
import java.util.List;

public class AirlineNetwork {

    private static final List<String> airports = new ArrayList<String>();
    private static final List<Flight> flights = new ArrayList<Flight>();

    public AirlineNetwork() {
        populateAirPorts();
        populateFlights();
    }

    private void populateAirPorts() {
        String[] airports = { "Mumbai", "Chennai", "Kolkata", "Delhi", "Bangalore" };
        for (String airport : airports)
            AirlineNetwork.airports.add(airport);
    }

    private void populateFlights() {
        Flight[] flights = { Flight.bangaloreToChennai, Flight.bangaloreToKolkata, Flight.bangaloreToMumbai, Flight.kolkataToChennai, Flight.mumbaiToBangalore };
        for (Flight flight : flights)
            AirlineNetwork.flights.add(flight);
    }

    public boolean registerAirport(final String airport) {
        if (airports.contains(airport)) return false;
        airports.add(airport);
        return true;
    }

    public void registerFlight(final Flight flight) {
        flights.add(flight);
    }

    public List<Flight[]> getFlights(final String origin, final String destination) {

        return null;
    }

}
