package com.example.authorization_service.config;

import com.example.authorization_service.repository.UserRepository;
import com.example.authorization_service.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository){
        return new AuthorizationService(userRepository);
    }
    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

}
