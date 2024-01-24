package com.example.FlyMile.AAscrapper;

import java.util.List;

public class Flight {
    private List<FlightDetail> flights;

    public Flight(List<FlightDetail> flights) {

        this.flights = flights;
    }


    public List<FlightDetail> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDetail> flights) {
        this.flights = flights;
    }
}
