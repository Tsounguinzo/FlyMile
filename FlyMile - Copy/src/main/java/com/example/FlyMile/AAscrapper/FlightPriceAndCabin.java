package com.example.FlyMile.AAscrapper;


public class FlightPriceAndCabin
{
    protected String points;
    protected  String cashPrice;
    protected String cabin;

    private static final String currency = "USD";

    public String getCabin() {
        return cabin;
    }
    public FlightPriceAndCabin setPoints(String points) {
        return new FlightPriceAndCabin(points, this.cashPrice, this.cabin);
    }

    public FlightPriceAndCabin setCashPrice(String cashPrice) {
        return new FlightPriceAndCabin(this.points, cashPrice, this.cabin);
    }

    public FlightPriceAndCabin setCabin(String cabin) {
        return new FlightPriceAndCabin(this.points, this.cashPrice, cabin);
    }

    public FlightPriceAndCabin(String points, String cashPrice, String cabin)
    {
        this.points = points;
        this.cashPrice = cashPrice;
        this.cabin = cabin;

    }
    public FlightPriceAndCabin()
    {}

    // Parse points string like "40K" to numeric value


    public String getPoints()
    {
        return points;
    }

    public String getCashPrice()
    {
        return cashPrice;
    }

    @Override
    public String toString()
    {
        return "cabin: " + cabin + " " +  points + " + " + cashPrice + " " + currency;
    }


}
