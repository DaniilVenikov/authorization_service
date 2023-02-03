package com.example.authorization_service.controller;

import com.example.authorization_service.model.User;
import com.example.authorization_service.repository.Authorities;
import com.example.authorization_service.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service){
        this.service = service;
    }
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);
    }

    @GetMapping("/registration")
    public void registration(@Valid User user){
        service.registration(user);
    }
}
