package com.flights.flight.service;


import com.flights.flight.pojo.Flight;
import com.flights.flight.pojo.FlightBuilder;
import com.flights.flight.pojo.FlightCreateRequest;
import com.flights.flight.pojo.FlightSearchRequest;
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

        return new ResponseEntity<>(flightRepository.getFlights(
                request.getWhenceAirportCode(),
                request.getDestinationAirportCode(),
                request.getDepartureDate(),
                request.getPeopleAmount()), HttpStatus.OK);
    }

    private boolean flightExists(String flightNumber) {
        return getFlightByNumber(flightNumber) != null;
    }

    private Flight getFlightByNumber(String flightNumber) {
        return flightRepository.getFlightByNumber(flightNumber);
    }

}
