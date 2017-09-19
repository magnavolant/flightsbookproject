package com.flights.user.service;

import com.flights.user.pojo.*;
import com.flights.user.repository.UserAdditionalInfoRepository;
import com.flights.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserAdditionalInfoRepository userAdditionalInfoRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserAdditionalInfoRepository userAdditionalInfoRepository) {

        this.userRepository = userRepository;
        this.userAdditionalInfoRepository = userAdditionalInfoRepository;
    }

    public ResponseEntity<UserRegisterResponse> create(UserRegisterRequest request) {

        if (!userAlreadyExists(request.getEmail())) {
            User user = new User(request.getEmail(), request.getPassword(), User.USER);
            userRepository.save(user);
            return new ResponseEntity<>(new UserRegisterResponse(), HttpStatus.OK);
        } else {
            UserRegisterResponse errorResponse =
                    new UserRegisterResponse(false, "USER WITH EMAIL " + request.getEmail() + " ALREADY EXISTS");

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity changeUserAdditionalInfo(UserChangeInfoRequest request) {

        User user = getUserByEmail(request.getEmail());
        if (user != null) {
            int userId = user.getId();
            if (userAdditionalInfoAlreadyExists(userId)) {
                userAdditionalInfoRepository.setUserInfoByUserId(userId, request.getName(), request.getSurname());
                return new ResponseEntity(HttpStatus.OK);
            } else {
                userAdditionalInfoRepository.save(new UserAdditionalInfo(userId, request.getName(), request.getSurname()));
                return new ResponseEntity(HttpStatus.OK);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity getUserAdditionalInfoByEmail(String email) {
        User user = getUserByEmail(email);
        if (user != null) {
            int userId = user.getId();
            if (userAdditionalInfoRepository.getUserAdditionalInfoByUserId(userId) != null) {
                UserAdditionalInfo userInfo = userAdditionalInfoRepository
                        .getUserAdditionalInfoByUserId(userId);
                return new ResponseEntity<>(userInfo, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    private boolean userAdditionalInfoAlreadyExists(int userId) {
        return userAdditionalInfoRepository.getUserAdditionalInfoByUserId(userId) != null;
    }

    private boolean userAlreadyExists(String email) {
        return getUserByEmail(email) != null;
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }


}
