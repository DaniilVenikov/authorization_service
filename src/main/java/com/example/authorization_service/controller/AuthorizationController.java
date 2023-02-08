package com.example.authorization_service.controller;

import com.example.authorization_service.config.UserValidated;
import com.example.authorization_service.model.Person;
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

    /*
    проверка валидации параметров через свою аннотацию
     */
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@UserValidated Person user) {
        return service.getAuthorities(user);
    }

    /*
    проверка валидации параметров через инструменты, предоставляемые Spring
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid Person user) {
        return service.getAuthorities(user);
    }*/
}
