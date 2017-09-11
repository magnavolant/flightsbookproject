package com.flights.user.controller;

import com.flights.user.pojo.UserChangeInfoRequest;
import com.flights.user.pojo.UserRegisterRequest;
import com.flights.user.pojo.UserRegisterResponse;
import com.flights.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return userService.create(request);
    }

    @RequestMapping(value = "/updateinfo", method = RequestMethod.POST)
    public ResponseEntity updateInfo(@RequestBody UserChangeInfoRequest request) {
        return userService.changeUserAdditionalInfo(request);
    }

    @RequestMapping(value = "/getAdditionalInfo/{email}")
    public ResponseEntity getUserAdditionalInfo(@PathVariable("email") String email) {
        return userService.getUserAdditionalInfoByEmail(email);
    }
}
