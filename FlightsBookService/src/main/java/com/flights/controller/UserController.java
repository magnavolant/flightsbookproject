package com.flights.controller;

import com.flights.pojo.UserRegisterRequest;
import com.flights.pojo.UserRegisterResponse;
import com.flights.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest request) {
        UserRegisterResponse response = userService.create(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
