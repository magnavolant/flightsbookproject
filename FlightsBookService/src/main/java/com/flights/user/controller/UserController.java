package com.flights.user.controller;

import com.flights.user.pojo.UserChangeInfoRequest;
import com.flights.user.pojo.UserRegisterRequest;
import com.flights.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping (value = "/register", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserRegisterRequest request) {
        ResponseEntity responseEntity = userService.create(request);

        return responseEntity;
    }








//    @RequestMapping(value = "/register", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public String register(@ModelAttribute UserRegisterRequest request, Model model) {
//
//        if (userService.create(request).getBody().isSuccess()) {
//            model.addAttribute("userExists", true);
//            return "index";
//        } else {
//            model.addAttribute("userExists", false);
//            return "index";
//        }
//    }


    @RequestMapping(value = "/updateinfo", method = RequestMethod.POST)
    public ResponseEntity updateInfo(@RequestBody UserChangeInfoRequest request) {
        return userService.changeUserAdditionalInfo(request);
    }

    @RequestMapping(value = "/getAdditionalInfo/{email}")
    public ResponseEntity getUserAdditionalInfo(@PathVariable("email") String email) {
        return userService.getUserAdditionalInfoByEmail(email);
    }
}
