package com.flights.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

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
}