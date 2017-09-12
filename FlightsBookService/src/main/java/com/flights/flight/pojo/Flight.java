package com.flights.flight.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table(name = "sb_flight")
public class Flight{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    private String flightNumber;

    @Column(name = "destination")
    private String destination;

    @Column(name = "whence")
    private String whence;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "flight_time")
    private LocalTime flightTime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "free_seats")
    private int freeSeatsNumber;


    public Flight(){}

    public Flight(String flightNumber, String destination, String whence, LocalDateTime departureDate, LocalTime flightTime, BigDecimal price, int freeSeatsNumber) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.whence = whence;
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.price = price;
        this.freeSeatsNumber = freeSeatsNumber;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getWhence() {
        return whence;
    }

    public void setWhence(String whence) {
        this.whence = whence;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getFreeSeatsNumber() {
        return freeSeatsNumber;
    }

    public void setFreeSeatsNumber(int freeSeatsNumber) {
        this.freeSeatsNumber = freeSeatsNumber;
    }
}




