package com.flights.flight.controller;


import com.flights.flight.pojo.*;
import com.flights.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(value = "/createflight", method = RequestMethod.POST)
    public ResponseEntity<FlightCreateResponse> create(@RequestBody FlightCreateRequest flightCreateRequest) {
        FlightCreateResponse flightCreateResponse = flightService.create(flightCreateRequest);
        return new ResponseEntity<>(flightCreateResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/getflights", method = RequestMethod.POST)
    public ResponseEntity<?> getFlights(@RequestBody FlightSearchRequest flightSearchRequest) {
        return flightService.getFlights(flightSearchRequest);
    }

    @RequestMapping(value = "/getAirports/{request}", method = RequestMethod.GET)
    public ResponseEntity<List<Airport>> getAirports(@PathVariable String request){
        return flightService.getAirports(request);
    }

}
