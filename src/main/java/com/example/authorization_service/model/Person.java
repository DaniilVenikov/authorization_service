package com.example.authorization_service.model;

import com.example.authorization_service.repository.Authorities;

import java.util.List;
import java.util.Objects;

public class Person {

    private String user;
    private String password;
    private List<Authorities> privileges;

    public Person() {
    }

    public Person(String user, String password, List<Authorities> privileges) {
        this.user = user;
        this.password = password;
        this.privileges = privileges;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Authorities> privileges) {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(user, person.user) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }
}
