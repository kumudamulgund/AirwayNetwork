package com.travels;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AirWaysNetworkTest {

    private final AirWaysNetwork airWaysNetwork = new AirWaysNetwork();

    @Test
    public void directFlightsFromValidSourceAndDestination() throws Exception {
        List<Flight> flights = airWaysNetwork.getFlights("Chennai", "Bengaluru");
        assertEquals(2, flights.size());
    }

    @Test(expected = InvalidSourceOrDestination.class)
    public void invalidSourceOrDestinationShouldThrowException() throws Exception {
        airWaysNetwork.getFlights("Hyderabad", "Delhi");
    }
}
