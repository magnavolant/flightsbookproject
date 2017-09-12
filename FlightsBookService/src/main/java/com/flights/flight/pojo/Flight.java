package com.flights.flight.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "sb_flight")
public class Flight{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String flightNumber;

    @Column(name = "destination")
    private String destination;

    @Column(name = "whence")
    private String whence;

    @Column(name = "departure_date")

    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "free_seats")
    private int freeSeatsNumber;


    public Flight(){}

    public Flight(String flightNumber, String destination, String whence, LocalDateTime departureDate, LocalDateTime arrivalDate, BigDecimal price, int freeSeatsNumber) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.whence = whence;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.freeSeatsNumber = freeSeatsNumber;
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

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
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




