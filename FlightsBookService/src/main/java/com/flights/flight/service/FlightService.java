package com.flights.flight.service;


import com.flights.flight.pojo.*;
import com.flights.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public FlightCreateResponse create(FlightCreateRequest flightCreateRequest) {
        if (!flightExists(flightCreateRequest.getFlightNumber())) {
            Flight flight = new FlightBuilder()
                    .setFlightNumber(flightCreateRequest.getFlightNumber())
                    .setDestination(flightCreateRequest.getDestination())
                    .setWhence(flightCreateRequest.getWhence())
                    .setDepartureDate(flightCreateRequest.getDepartureDate())
                    .setDepartureTime(flightCreateRequest.getDepartureTime())
                    .setArrivalDate(flightCreateRequest.getFlightTime())
                    .setPrice(flightCreateRequest.getPrice())
                    .setFreeSeatsNumber(flightCreateRequest.getFreeSeatsNumber())
                    .createFlight();

            flightRepository.save(flight);
            return new FlightCreateResponse();
        } else {
            return new FlightCreateResponse(
                    false, "Flight " + flightCreateRequest.getFlightNumber() + " already exists");
        }
    }

    public ResponseEntity<List<Flight>> getFlights(FlightSearchRequest request) {

        List<Flight> flights = flightRepository.getFlights(
                request.getWhenceAirportCode(),
                request.getDestinationAirportCode(),
                request.getDepartureDate(),
                request.getPeopleAmount()
        );

        if(!flights.isEmpty()){
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Airport>> getAirports(String request){

        List<Airport> airports = flightRepository.getAirports(request);

        if(!airports.isEmpty()){
            return new ResponseEntity<>(airports, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private boolean flightExists(String flightNumber) {
        return getFlightByNumber(flightNumber) != null;
    }

    private Flight getFlightByNumber(String flightNumber) {
        return flightRepository.getFlightByNumber(flightNumber);
    }

}
