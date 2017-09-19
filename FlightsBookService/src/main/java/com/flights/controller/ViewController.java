package com.flights.controller;

import com.flights.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {


    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/testflightspage", method = RequestMethod.GET)
    public String flightsPage(){
        return "testflightspage";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutPage(){
        return "about";
    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public String flightPage(){
        return "flights";
    }







}
