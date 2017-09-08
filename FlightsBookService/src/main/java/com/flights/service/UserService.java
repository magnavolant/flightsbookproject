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

        if(!alreadyExists(request.getEmail())){
            User user = new User(request.getEmail(), request.getPassword(), User.USER);
            userRepository.save(user);
            return new UserRegisterResponse();
        }else {
            return new UserRegisterResponse
                    (false, "USER WITH EMAIL " + request.getEmail() + " ALREADY EXISTS");
        }
    }

    private boolean alreadyExists(String email){
        return getUserByEmail(email) != null;
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }
}
