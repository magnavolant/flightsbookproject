package com.flights.user.controller;

import com.flights.user.pojo.UserAdditionalInfo;
import com.flights.user.pojo.UserChangeInfoRequest;
import com.flights.user.pojo.UserRegisterRequest;
import com.flights.user.pojo.UserRegisterResponse;
import com.flights.user.service.UserService;
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

    @RequestMapping(value = "/updateinfo", method = RequestMethod.POST)
    public ResponseEntity updateInfo(@RequestBody UserChangeInfoRequest request) {
        boolean success = userService.changeUserAdditionalInfo(request);
        if (success) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/getAdditionalInfo/{email}")
    public UserAdditionalInfo getUserAdditionalInfo(@PathVariable("email") String email) {
        return userService.getUserAdditionalInfoByEmail(email);
    }
}
