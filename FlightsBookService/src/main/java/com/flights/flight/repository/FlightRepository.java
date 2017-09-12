package com.flights.flight.repository;

import com.flights.flight.pojo.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Integer> {


    @Query("SELECT F FROM Flight F WHERE F.flightNumber = :flight_number")
    Flight getFlightByNumber(@Param("flight_number") String flightNumber);

    @Query("SELECT F FROM Flight F WHERE F.whence =?1 AND F.destination=?2 AND " +
            "(F.departureDate>=?3 OR F.departureDate<=?3) AND F.freeSeatsNumber >= ?4")
    List<Flight> getFlights(String departureAirport, String arrivalAirport, LocalDateTime departureTime, int peopleAmount);
}
