package com.travels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AirlineNetwork {

    private static final List<String> airports = new ArrayList<String>();
    private static final List<Flight> flights = new ArrayList<Flight>();

    public AirlineNetwork() {
        populateAirPorts();
        populateFlights();

    }

    private void populateAirPorts() {
        String[] airports = { "Mumbai", "Chennai", "Kolkata", "Bangalore" };
        for (String airport : airports)
            AirlineNetwork.airports.add(airport);
    }

    private void populateFlights() {
        Flight[] flights = { Flight.bangaloreToChennai, Flight.bangaloreToKolkata, Flight.bangaloreToMumbai, Flight.kolkataToChennai, Flight.mumbaiToBangalore };
        for (Flight flight : flights)
            AirlineNetwork.flights.add(flight);
    }

    public boolean registerAirport(final String airport) {
        if (airports.contains(airport)) return false;
        airports.add(airport);
        return true;
    }

    public void registerFlight(final Flight flight) {
        flights.add(flight);
    }

    public ArrayList<String> getFlights(final String origin, final String destination) {
        HashMap<String, HashMap<String, Object>> routeMap = new HashMap<String, HashMap<String, Object>>();
        final List<String> visitedAirports = new ArrayList<String>();
        List<String> airportsToVist = airports;
        routeMap = addAllPaths(origin, 0, routeMap, visitedAirports, airportsToVist);
        ArrayList<String> path = getPath(origin, destination, routeMap, new ArrayList<String>());
        Collections.reverse(path);
        return path;
    }

    private String getNearestAirport(final HashMap<String, HashMap<String, Object>> routeMap, final List<String> visitedAirports) {
        int maxDistance = Integer.MAX_VALUE;
        String nearestNode = null;
        Iterator routes = routeMap.entrySet().iterator();
        while (routes.hasNext()) {
            Map.Entry route = (Map.Entry) routes.next();
            HashMap<String, Object> currentFlightMap = (HashMap<String, Object>) route.getValue();
            if (!visitedAirports.contains(route.getKey()) || visitedAirports.contains(route.getKey()) && (int) currentFlightMap.get("distance") < maxDistance) {
                maxDistance = (int) currentFlightMap.get("distance");
                nearestNode = (String) route.getKey();

            }
        }
        return nearestNode;
    }

    private HashMap<String, HashMap<String, Object>> addAllPaths(final String origin, int currentWeight,
            final HashMap<String, HashMap<String, Object>> routeMap, final List<String> visitedAirports, final List<String> airportsToVisit) {
        int indexOfOrigin = airportsToVisit.indexOf(origin);
        if (indexOfOrigin != -1) airportsToVisit.remove(indexOfOrigin);

        String flightDestination = null;
        while (airportsToVisit.size() > 0) {
            for (Flight flight : flights) {
                HashMap<String, Object> flightDetails = flight.flightDetails();
                if (flight.fliesFrom(origin)) {
                    currentWeight += (Integer) flightDetails.get("distance");
                    flightDetails.put("distance", currentWeight);
                    flightDestination = (String) flightDetails.get("destination");
                    if (!routeMap.containsKey(flightDestination)) routeMap.put(flightDestination, flightDetails);
                    else if ((Integer) routeMap.get(flightDestination).get("distance") > currentWeight) routeMap.put(flightDestination, flightDetails);
                }
            }
            visitedAirports.add(origin);
            String nearestNode = getNearestAirport(routeMap, visitedAirports);
            if (nearestNode != null) {
                HashMap<String, Object> testVar = routeMap.get(nearestNode);
                int testDistance = (int) testVar.get("distance");
                if (flightDestination == null) addAllPaths(nearestNode, testDistance, routeMap, visitedAirports, airportsToVisit);
                addAllPaths(nearestNode, (Integer) routeMap.get(flightDestination).get("distance"), routeMap, visitedAirports, airportsToVisit);
            }
        }
        return routeMap;
    }

    private ArrayList<String> getPath(final String origin, final String destination, final HashMap<String, HashMap<String, Object>> routeMap,
            final ArrayList<String> flights) {
        HashMap<String, Object> flightDetails = routeMap.get(destination);
        flights.add((String) flightDetails.get("identifier"));
        if (!((String) flightDetails.get("origin")).equals(origin)) this.getPath(origin, (String) flightDetails.get("origin"), routeMap, flights);
        return flights;
    }

}
