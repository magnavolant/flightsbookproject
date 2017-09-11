package com.flights.flight.service;


import com.flights.flight.Flight;
import com.flights.flight.FlightCreateRequest;
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
            Flight flight = new Flight(flightCreateRequest.getFlightNumber(),
                    flightCreateRequest.getDestination(),
                    flightCreateRequest.getWhence(),
                    flightCreateRequest.getDepartureDate(),
                    flightCreateRequest.getArrivalDate(),
                    flightCreateRequest.getPrice(),
                    flightCreateRequest.getFreeSeatsNumber());
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
    /*

e {
            return new UserRegisterResponse
                    (false, "USER WITH EMAIL " + request.getEmail() + " ALREADY EXISTS");
        }
    }
*/
}
