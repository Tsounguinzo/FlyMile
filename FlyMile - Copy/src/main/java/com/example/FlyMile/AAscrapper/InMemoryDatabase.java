package com.example.FlyMile.AAscrapper;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private Map<String, Map<AirPair, FlightDetail>> database;

    public InMemoryDatabase() {
        database = new HashMap<>();
    }

    // Add a flight entry to the database
    public void addFlight(String date, AirPair airPair, FlightDetail flightDetails) {
        // Check if the date key exists in the database
        if (!database.containsKey(date)) {
            database.put(date, new HashMap<>());
        }

        // Add the flight details to the inner HashMap
        database.get(date).put(airPair, flightDetails);
    }


    // Retrieve flight details based on date and AirPair
    public FlightDetail getFlightDetails(String date, AirPair airPair) {
        if (database.containsKey(date)) {
            return database.get(date).get(airPair);
        }
        return null; // Flight not found for the given date and AirPair
    }
    // Add a new date to the database
    public void addDate(String date) {
        if (!database.containsKey(date)) {
            database.put(date, new HashMap<>());
        }
    }

    // Remove a date and all its associated flight entries from the database
    public void removeDate(String date) {
        database.remove(date);
    }
    // Remove a flight entry from the database
    public void removeFlight(String date, AirPair airPair) {
        if (database.containsKey(date)) {
            database.get(date).remove(airPair);
            // If the inner HashMap is empty after removal, remove the date key as well
            if (database.get(date).isEmpty()) {
                database.remove(date);
            }
        }
    }

}
