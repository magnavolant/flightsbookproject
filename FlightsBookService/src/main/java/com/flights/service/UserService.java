package com.flights.service;

import com.flights.pojo.User;
import com.flights.pojo.UserRegisterRequest;
import com.flights.pojo.UserRegisterResponse;
import com.flights.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //TODO implement checking for duplicate

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegisterResponse create(UserRegisterRequest request) {
        User user = new User(request.getEmail(), request.getPassword(), User.USER);
        userRepository.save(user);
        return new UserRegisterResponse();
    }

}
