package com.example.authorization_service.model;

import com.example.authorization_service.repository.Authorities;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

public class Person {

    @NotBlank
    @Size(min=2, max=50)
    private String user;

    @NotBlank
    @Size(min = 3, max = 50)
    private String password;

    private List<Authorities> privileges;

    public Person() {}

    public Person(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Person(String user, String password, List<Authorities> privileges) {
        this.user = user;
        this.password = password;
        this.privileges = privileges;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
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
        Person user = (Person) o;
        return Objects.equals(this.user, user.user) && Objects.equals(password, user.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
