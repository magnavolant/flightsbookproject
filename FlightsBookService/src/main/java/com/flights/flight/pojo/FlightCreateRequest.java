package com.flights.flight.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FlightCreateRequest {

    private String flightNumber;
    private BigDecimal price;
    private String whence;
    private String destination;
    private LocalDateTime departureDate;
    private LocalTime flightTime;
    private int freeSeatsNumber;

    DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public FlightCreateRequest(){}

    public String getFlightNumber() {
        return flightNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = BigDecimal.valueOf(price);
    }

    public int getFreeSeatsNumber() {
        return freeSeatsNumber;
    }

    public void setFreeSeatsNumber(int freeSeatsNumber) {
        this.freeSeatsNumber = freeSeatsNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getWhence() {
        return whence;
    }

    public void setWhence(String whence) {
        this.whence = whence;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setFlightTime (String flightTime) {
        this.flightTime = LocalTime.parse(flightTime);
    }

    public void setDepartureDate (String departureDate){
        this.departureDate = LocalDateTime.parse(departureDate, myFormatter);
    }
}
