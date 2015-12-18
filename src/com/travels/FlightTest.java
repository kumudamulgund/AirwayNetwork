package com.travels;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FlightTest {

    private final Flight flight = new Flight("Air India", 1800, 1000, "Mumbai");

    @Test
    public void whenFlightTravelsToDestination() throws Exception {
        assertEquals(true, flight.fliesTo("Mumbai"));
    }

    @Test
    public void whenFlightDoesNotTravelsToDestination() throws Exception {
        assertEquals(false, flight.fliesTo("Bengaluru"));
    }

}
