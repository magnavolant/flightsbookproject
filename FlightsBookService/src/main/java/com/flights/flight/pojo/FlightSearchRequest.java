package com.flights.flight.pojo;

import java.time.LocalDate;

public class FlightSearchRequest {

    private String whenceAirportCode;
    private String destinationAirportCode;
    private LocalDate departureDate;
    private int peopleAmount;

    public FlightSearchRequest() {
    }

    public String getWhenceAirportCode() {
        return whenceAirportCode;
    }

    public void setWhenceAirportCode(String whenceAirportCode) {
        this.whenceAirportCode = whenceAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = LocalDate.parse(departureDate);
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }
}
