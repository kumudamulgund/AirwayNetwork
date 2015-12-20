package com.travels;

import java.util.HashMap;

public class Flight {

    public static final Flight mumbaiToBangalore = new Flight("MB1", "Mumbai", "Bangalore", 1700);
    public static final Flight bangaloreToChennai = new Flight("BC1", "Bangalore", "Chennai", 400);
    public static final Flight bangaloreToKolkata = new Flight("BK1", "Bangalore", "Kolkata", 1000);
    public static final Flight bangaloreToMumbai = new Flight("BM1", "Bangalore", "Mumbai", 1700);
    public static final Flight kolkataToChennai = new Flight("KC1", "Kolkata", "Chennai", 1400);
    public static final Flight mumbaiToKolkata = new Flight("MK1", "Mumbai", "Kolkata", 1000);

    private final String identifier;
    private final String destination;
    private final String origin;
    private final int distance;

    public Flight(final String identifier, final String origin, final String destination, final int distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;

        this.identifier = identifier;
    }

    public boolean fliesFrom(final String origin) {
        return this.origin.equals(origin);
    }

    @Override
    public boolean equals(final Object flight) {
        if (flight == null) return false;
        if (!(flight instanceof Flight)) return false;
        Flight anotherFlight = (Flight) flight;
        if (!identifier.equals(anotherFlight.identifier)) return false;
        if (!origin.equals(anotherFlight.origin)) return false;
        if (!destination.equals(anotherFlight.destination)) return false;
        if (distance != anotherFlight.distance) return false;
        return true;
    }

    public HashMap<String, Object> flightDetails() {
        HashMap<String, Object> flightDetails = new HashMap<String, Object>();
        flightDetails.put("identifier", identifier);
        flightDetails.put("origin", origin);
        flightDetails.put("destination", destination);
        flightDetails.put("distance", distance);

        return flightDetails;
    }
}
