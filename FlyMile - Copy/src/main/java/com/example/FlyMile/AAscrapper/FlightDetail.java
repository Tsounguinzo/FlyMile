package com.example.FlyMile.AAscrapper;

import java.time.LocalDate;

public class FlightDetail {
    protected LocalDate date;
    protected String origin;
    protected String destination;
    protected String departureTime;
    protected String arrivalTime;
    protected String duration;
    protected String stops;
    protected String flightNumber;

    public FlightDetail() {
        this.priceAndCabin = new FlightPriceAndCabin[4];
    }

    protected String aircraft;

    public String getOperator() {
        return operator;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStops() {
        return stops;
    }

    protected String operator;
    protected FlightPriceAndCabin[] priceAndCabin;

    // Constructor
    public FlightDetail(String origin, String destination, String departureTime, String arrivalTime, String duration,
                        String stops, String flightNumber, String aircraft, String operator, LocalDate date, FlightPriceAndCabin priceAndCabinEconomy,
                        FlightPriceAndCabin priceAndCabinPremiumEconomy, FlightPriceAndCabin priceAndCabinBusiness,
                        FlightPriceAndCabin priceAndCabinFirst) {
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.stops = stops;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.operator = operator;
        this.date = date;
        this.priceAndCabin = new FlightPriceAndCabin[] {
                priceAndCabinEconomy,
                priceAndCabinPremiumEconomy,
                priceAndCabinBusiness,
                priceAndCabinFirst
        };
    }


    // Getter methods
   

    public FlightPriceAndCabin getPriceCabinEconomy()
    {
        return priceAndCabin[0];
    }
    public FlightPriceAndCabin getPriceCabinPremiumEconomy()
    {
        return priceAndCabin[1];
    }
    public FlightPriceAndCabin getPriceCabinBusiness()
    {
        return priceAndCabin[2];
    }
    public FlightPriceAndCabin getPriceCabinFirst()
    {
        return priceAndCabin[3];
    }



    // toString() method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append("Date: ").append(date)
                 .append(", Origin: ").append(origin)
                .append(", Destination: ").append(destination)
                .append(", Departure Time: ").append(departureTime)
                .append(", Arrival Time: ").append(arrivalTime)
                .append(", Duration: ").append(duration)
                .append(", Stops: ").append(stops)
                .append(", Flight Number: ").append(flightNumber)
                .append(", Aircraft: ").append(aircraft)
                .append(", Operator: ").append(operator);

        if (priceAndCabin[0] != null) {
            sb.append("\nEconomy: ").append(formatCabinDetails(priceAndCabin[0]));
        }
        if (priceAndCabin[1] != null) {
            sb.append("\nPremium Economy: ").append(formatCabinDetails(priceAndCabin[1]));
        }
        if (priceAndCabin[2] != null) {
            sb.append("\nBusiness: ").append(formatCabinDetails(priceAndCabin[2]));
        }
        if (priceAndCabin[3] != null) {
            sb.append("\nFirst: ").append(formatCabinDetails(priceAndCabin[3]));
        }
        return sb.toString();
    }

    private String formatCabinDetails(FlightPriceAndCabin cabinDetails)
    {
        if (cabinDetails.points == null || cabinDetails.cashPrice == null)
            return "Not available";
        return "Points: " + cabinDetails.points + ", Cash: " + cabinDetails.cashPrice + " USD";
    }


}
