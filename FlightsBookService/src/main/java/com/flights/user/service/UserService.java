package com.flights.user.service;

import com.flights.user.pojo.*;
import com.flights.user.repository.UserAdditionalInfoRepository;
import com.flights.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public boolean changeUserAdditionalInfo(UserChangeInfoRequest request) {
        User user = getUserByEmail(request.getEmail());
        if (user != null) {
            int userId = user.getId();
            userAdditionalInfoRepository.setUserInfoByUserId
                    (userId, request.getName(), request.getSurname());
            return true;
        } else {
            return false;
        }
    }

    public UserAdditionalInfo getUserAdditionalInfoByEmail(String email) {
        int userId = getUserByEmail(email).getId();
        if (userAdditionalInfoRepository != null) {
            return userAdditionalInfoRepository.getUserAdditionalInfoByUserId(userId);
        } else {
            return new UserAdditionalInfo();
        }
    }

    public UserRegisterResponse create(UserRegisterRequest request) {

        if (!userAlreadyExists(request.getEmail())) {
            User user = new User(request.getEmail(), request.getPassword(), User.USER);
            userRepository.save(user);
            return new UserRegisterResponse();
        } else {
            return new UserRegisterResponse
                    (false, "USER WITH EMAIL " + request.getEmail() + " ALREADY EXISTS");
        }
    }

    private boolean userAlreadyExists(String email) {
        return getUserByEmail(email) != null;
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
