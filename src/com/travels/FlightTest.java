package com.travels;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.travels.Flight;

public class FlightTest {

    private final Flight flight = new Flight("Air India", 1800, 1000, "Mumbai");

    @Test
    public void whenFlightTravelsToDestination() throws Exception {
        assertEquals(true, flight.checkIfFliesTo("Mumbai"));
    }

    @Test
    public void whenFlightDoesNotTravelsToDestination() throws Exception {
        assertEquals(false, flight.checkIfFliesTo("Bengaluru"));
    }

}
