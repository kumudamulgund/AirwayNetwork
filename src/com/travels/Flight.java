package com.travels;

public class Flight {

    private final String destination;
    private final int price;
    private final int distance;
    

    public Flight(final int price, final int distance, final String destination) {
        validateDestination(destination);
        this.destination = destination;
        this.price =price;
        this.distance = distance;
                
    }
    
    private void validateDestination(String destination) {
        AirportNetwork.doesAirportExist(destination);
    }

    public boolean checkIfFliesTo(final String destination) {
        return this.destination.equals(destination);
    }

    public boolean checkByBest() {

    }
}
