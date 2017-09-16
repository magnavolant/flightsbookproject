package com.flights.flight.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "sb_flight")
public class Flight{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name = "flight_number")
    private String flightNumber;

    private String destination;

    private String whence;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "flight_time")
    private LocalTime flightTime;

    private BigDecimal price;

    @Column(name = "free_seats")
    @JsonIgnore
    private int freeSeatsNumber;


    public Flight(){}

    public Flight(String flightNumber, String destination, String whence, LocalDate departureDate, LocalTime departureTime, LocalTime flightTime, BigDecimal price, int freeSeatsNumber) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.whence = whence;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.flightTime = flightTime;
        this.price = price;
        this.freeSeatsNumber = freeSeatsNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
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




