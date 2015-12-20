package com.travels;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AirLineNetworkTest {

    @Test
    public void validSourceAndDestinationShouldProvideListOfFlights() throws Exception {
        AirlineNetwork airlineNetwork = new AirlineNetwork();
        List<String> flights = airlineNetwork.getFlights("Mumbai", "Chennai");
        assertEquals("MB1", flights.get(0));
        assertEquals("BC1", flights.get(1));
    }

    @Test
    public void directflightWithLowerDistance() throws Exception {
        AirlineNetwork airlineNetwork = new AirlineNetwork();
        List<String> flights = airlineNetwork.getFlights("Mumbai", "Bangalore");
        assertEquals("MB1", flights.get(0));
    }

}
