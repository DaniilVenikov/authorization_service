package com.example.authorization_service.repository;

import com.example.authorization_service.model.Person;


import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private final ConcurrentHashMap<String, Person> repository = new ConcurrentHashMap<>();

    {
        repository.put("daniil", new Person("daniil", "123", List.of(Authorities.WRITE, Authorities.READ, Authorities.DELETE)));
        repository.put("alex", new Person("alex", "861", List.of(Authorities.WRITE, Authorities.READ)));
        repository.put("bob", new Person("bob", "321", List.of(Authorities.READ)));

    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        if(isPerson(user)){
            Person temp = repository.get(user);
            if(temp.getPassword().equals(password)){
                return temp.getPrivileges();
            }
        }
        return List.of();
    }

    private boolean isPerson(String user){
        return repository.values()
                .stream()
                .anyMatch((person -> person.getUser().equals(user)));
    }
}
