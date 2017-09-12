package com.flights.flight.repository;

import com.flights.flight.pojo.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends CrudRepository<Flight,Integer>{


    @Query("SELECT F FROM Flight F WHERE F.flightNumber = :flight_number")
    Flight getFlightByNumber(@Param("flight_number") String flightNumber);

}
