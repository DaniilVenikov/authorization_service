package com.example.authorization_service.service;


import com.example.authorization_service.exception.InvalidCredentials;
import com.example.authorization_service.exception.UnauthorizedUser;
import com.example.authorization_service.model.User;
import com.example.authorization_service.repository.Authorities;
import com.example.authorization_service.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<Authorities> getAuthorities(User user) {
        String userName = user.getUser();
        String password = user.getPassword();
        if (isEmpty(userName) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + userName);
        }
        return userAuthorities;
    }

    public void registration(User user){
        userRepository.addNewUser(user.getUser(), user.getPassword());
        System.out.println("User added");
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
