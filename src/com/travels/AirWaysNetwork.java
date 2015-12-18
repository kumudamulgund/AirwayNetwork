package com.travels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class AirWaysNetwork {

    private static final Set<String> airports = new HashSet<String>();
    private static final TreeMap<String, List<Flight>> flightDetails = new TreeMap<String, List<Flight>>();

    public AirWaysNetwork() {
        createAirports();
        String[] airLines = { "Air India", "Spice Jet" };
        int[] chennaiToDelhiPrices = { 18000, 15000 };
        airportDetails("Chennai", airLines, chennaiToDelhiPrices, 2500, "Delhi");
        int[] chennaiToBengaluruPrices = { 6000, 4000 };
        airportDetails("Chennai", airLines, chennaiToBengaluruPrices, 500, "Bengaluru");
        int[] bangaloreToChennaiPrices = { 5000, 3000 };
        airportDetails("Bengaluru", airLines, bangaloreToChennaiPrices, 500, "Chennai");
        int[] delhiToBangalorePrices = { 15000, 12000 };
        airportDetails("Delhi", airLines, delhiToBangalorePrices, 2000, "Bengaluru");
    }

    private void createAirports() {
        String[] airports = { "Bengaluru", "Mumbai", "Kolkata", "Chennai", "Delhi" };
        for (String airport : airports)
            this.registerAirports(airport);
    }

    private void airportDetails(final String source, final String[] airLines, final int[] prices, final int distance, final String destination) {
        int i = 0;
        Flight flight;
        List<Flight> flights = new ArrayList<Flight>();
        for (String airLine : airLines) {
            flight = new Flight(airLine, prices[i], distance, destination);
            flights.add(flight);
        }
        flightDetails.put(source, flights);
    }

    public static boolean doesAirportExist(final String airportName) {
        if (!airports.contains(airportName)) return false;
        return true;
    }

    public boolean registerAirports(final String name) {
        if (!doesAirportExist(name)) {
            airports.add(name);
            return true;
        }
        return false;
    }

    public boolean registerFlights(final String source, final Flight flight) {
        if (doesAirportExist(source)) {
            List<Flight> flights = flightDetails.get(source);
            flights.add(flight);
            return true;
        }
        return false;
    }

    public List<Flight> getFlights(final String source, final String destination) throws InvalidSourceOrDestination {
        if (!doesAirportExist(source) && doesAirportExist(destination)) throw new InvalidSourceOrDestination("Invalid source or destination");
        List<Flight> flights = new ArrayList<Flight>();
        for (Flight flight : flightDetails.get(source))
            if (flight.fliesTo(destination)) flights.add(flight);
        return flights;
    }

}