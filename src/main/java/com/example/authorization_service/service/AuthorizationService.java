package com.example.authorization_service.service;

import com.example.authorization_service.exception.InvalidCredentials;
import com.example.authorization_service.exception.UnauthorizedUser;
import com.example.authorization_service.repository.Authorities;
import com.example.authorization_service.repository.UserRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    public void registration(String user, String password){
        userRepository.addNewUser(user, password);
        System.out.println("User added");
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
