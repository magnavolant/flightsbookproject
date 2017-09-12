package com.flights.flight.controller;


import com.flights.flight.pojo.FlightCreateRequest;
import com.flights.flight.service.FlightCreateResponse;
import com.flights.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



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
}
