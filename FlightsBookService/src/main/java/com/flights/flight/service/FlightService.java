package com.flights.flight.service;


import com.flights.flight.pojo.Flight;
import com.flights.flight.pojo.FlightBuilder;
import com.flights.flight.pojo.FlightCreateRequest;
import com.flights.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    public FlightCreateResponse create (FlightCreateRequest flightCreateRequest){
        if (!flightExists(flightCreateRequest.getFlightNumber())){
            Flight flight = new FlightBuilder()
                    .setFlightNumber(flightCreateRequest.getFlightNumber())
                    .setDestination(flightCreateRequest.getDestination())
                    .setWhence(flightCreateRequest.getWhence())
                    .setDepartureDate(flightCreateRequest.getDepartureDate())
                    .setArrivalDate(flightCreateRequest.getArrivalDate())
                    .setPrice(flightCreateRequest.getPrice())
                    .setFreeSeatsNumber(flightCreateRequest.getFreeSeatsNumber())
                    .createFlight();

            flightRepository.save(flight);
            return new FlightCreateResponse();
        }else {
            return new FlightCreateResponse(
                    false, "Flight " + flightCreateRequest.getFlightNumber() + " already exists");
        }
    }

    private boolean flightExists(String flightNumber){
        return getFlightByNumber(flightNumber) != null;
    }

    private Flight getFlightByNumber(String flightNumber){
        return flightRepository.getFlightByNumber(flightNumber);
    }

}
