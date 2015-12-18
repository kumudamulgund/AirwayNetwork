package com.travels;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AirLineNetworkTest {

    private final AirlineNetwork airlineNetwork = new AirlineNetwork();

    @Test
    public void newAirportShouldBeRegistered() throws Exception {
        assertEquals(true, airlineNetwork.registerAirport("Hyderabad"));
    }

    @Test
    public void alreadyRegisteredAirportShouldNotBeRegistered() throws Exception {
        assertEquals(false, airlineNetwork.registerAirport("Delhi"));
    }

    @Test
    public void validSourceAndDestinationShouldProvideListOfFlights() throws Exception {
        List<Flight[]> flights = airlineNetwork.getFlights("Mumbai", "Kolkata");
    }

}
