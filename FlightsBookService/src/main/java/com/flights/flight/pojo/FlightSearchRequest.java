package com.flights.flight.pojo;

import java.time.LocalDate;

public class FlightSearchRequest {

    private String whenceAirportCode;
    private String destinationAirportCode;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
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
        if (departureDate != null) {
            this.departureDate = LocalDate.parse(departureDate);
        } else this.departureDate = null;
    }

    public void setArrivalDate(String arrivalDate) {
        if (arrivalDate != null) {
            this.arrivalDate = LocalDate.parse(arrivalDate);
        } else this.arrivalDate = null;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }
}
