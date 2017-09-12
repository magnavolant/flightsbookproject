package com.flights.flight.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightCreateRequest {

    private String flightNumber;
    private BigDecimal price;
    private String whence;
    private String destination;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
    private int freeSeatsNumber;


    DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");;

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

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

//    public void setArrivalDate(LocalDate arrivalDate) {
//        this.arrivalDate = arrivalDate;
//    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

//    public void setDepartureDate(LocalDate departureDate) {
//        this.departureDate = departureDate;
//    }

    public void setArrivalDate (String arrivalDate) {
        this.arrivalDate = LocalDateTime.parse(arrivalDate, myFormatter);
    }


    public void setDepartureDate (String departureDate){
        this.departureDate = LocalDateTime.parse(departureDate, myFormatter);
    }
}
