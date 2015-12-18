package com.travels;

public class Flight {

    private final String destination;

    public Flight(final String name, final int price, final int distance, final String destination) {
        validateDestination(destination);
        this.destination = destination;

    }

    private void validateDestination(final String destination) {
        AirWaysNetwork.doesAirportExist(destination);
    }

    public boolean fliesTo(final String destination) {
        return this.destination.equals(destination);
    }

}
