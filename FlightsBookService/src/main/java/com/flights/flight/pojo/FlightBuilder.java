package com.flights.flight.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FlightBuilder {
    private String flightNumber;
    private String destination;
    private String whence;
    private LocalDateTime departureDate;
    private LocalTime flightTime;
    private BigDecimal price;
    private int freeSeatsNumber;

    public FlightBuilder setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
        return this;
    }

    public FlightBuilder setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public FlightBuilder setWhence(String whence) {
        this.whence = whence;
        return this;
    }

    public FlightBuilder setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public FlightBuilder setArrivalDate(LocalTime flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public FlightBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public FlightBuilder setFreeSeatsNumber(int freeSeatsNumber) {
        this.freeSeatsNumber = freeSeatsNumber;
        return this;
    }

    public Flight createFlight() {
        return new Flight(flightNumber, destination, whence, departureDate, flightTime, price, freeSeatsNumber);
    }
}