package com.example.authorization_service.repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private final ConcurrentHashMap<String, String> repository = new ConcurrentHashMap<>();

    {
        repository.put("daniil", "123");
        repository.put("alex", "861");
        repository.put("bob", "321");

    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        String check = repository.get(user);
        if(check != null && check.equals(password)){
            return List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE);
        }
        return List.of();
    }
    public void addNewUser(String user, String password){
        repository.put(user, password);
    }
}
