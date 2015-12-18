package com.travels;

import java.util.HashMap;

public class Flight {

    public static final Flight mumbaiToBangalore = new Flight("Mumbai", "Bangalore", 1700);
    public static final Flight bangaloreToChennai = new Flight("Bangalore", "Chennai", 400);
    public static final Flight bangaloreToKolkata = new Flight("Bangalore", "Kolkata", 1000);
    public static final Flight bangaloreToMumbai = new Flight("Bangalore", "Mumbai", 1700);
    public static final Flight kolkataToChennai = new Flight("Kolkata", "Chennai", 1400);
    public static final Flight mumbaiToKolkata = new Flight("Mumbai", "Kolkata", 1000);

    private final String destination;
    private final String origin;
    private final int distance;

    public Flight(final String source, final String destination, final int distance) {
        origin = source;
        this.destination = destination;
        this.distance = distance;

    }

    public boolean fliesFrom(final String origin) {
        return this.origin.equals(origin);
    }

    public boolean fliesTo(final String destination) {
        return this.destination.equals(destination);
    }

    @Override
    public boolean equals(final Object flight) {
        if (flight == null) return false;
        if (!(flight instanceof Flight)) return false;
        Flight anotherFlight = (Flight) flight;
        if (!origin.equals(anotherFlight.origin)) return false;
        if (!destination.equals(anotherFlight.destination)) return false;
        if (distance != anotherFlight.distance) return false;
        return true;
    }

    public HashMap<String, Object> flightDetails() {
        HashMap<String, Object> flightDetails = new HashMap<String, Object>();
        flightDetails.put("origin", origin);
        flightDetails.put("destination", destination);
        flightDetails.put("distance", distance);

        return flightDetails;
    }
}
