package com.example.authorization_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {

    @NotBlank
    @Size(min=2, max=50)
    private String user;

    @NotBlank
    @Size(min = 3, max = 50)
    private String password;

    public User() {}

    public User(String name, String password) {
        this.user = name;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
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
