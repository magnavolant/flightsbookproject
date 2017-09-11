package com.flights.user.service;

import com.flights.user.pojo.UserRegisterRequest;
import com.flights.user.pojo.UserRegisterResponse;
import com.flights.user.repository.UserAdditionalInfoRepository;
import com.flights.user.repository.UserRepository;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {


    private UserRepository userRepository;
    private UserAdditionalInfoRepository userAdditionalInfoRepository;

    private UserService userService;

    public UserServiceTest() {
        userRepository = Mockito.mock(UserRepository.class);
        userAdditionalInfoRepository = Mockito.mock(UserAdditionalInfoRepository.class);

        userService = new UserService(userRepository, userAdditionalInfoRepository);
    }

    @Test
    public void shouldCreateUserWhenNotExistInDB() {
        //GIVEN
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest("email@gmail.com", "password");
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        ResponseEntity<UserRegisterResponse> expectedResponse =
                new ResponseEntity<>(userRegisterResponse, HttpStatus.OK);
        //WHEN
        when(userRepository.getUserByEmail(Matchers.anyString())).thenReturn(null);

        //THEN
        assertEquals(userService.create(userRegisterRequest), expectedResponse);
    }
}