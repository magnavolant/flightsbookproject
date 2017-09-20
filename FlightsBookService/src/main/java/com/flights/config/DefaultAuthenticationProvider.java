package com.flights.config;

import com.flights.user.pojo.User;
import com.flights.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {

    private UserRepository userRepository;

    @Autowired
    public DefaultAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = ((String) authentication.getPrincipal());
        String password = ((String) authentication.getCredentials());

        User user = userRepository.getUserByEmail(email);

        if (user != null && user.isEnabled()) {
            if (user.getPassword().equals(password)) {
                if (user.getRole() == User.USER) {
                    return new UsernamePasswordAuthenticationToken
                            (email, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
                } else if (user.getRole() == User.ADMIN) {
                    return new UsernamePasswordAuthenticationToken
                            (email, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
                }
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
