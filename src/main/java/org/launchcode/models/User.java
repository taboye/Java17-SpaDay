package org.launchcode.models;

import java.time.LocalDate;

public class User {
    //Bonus mission for id

    private static int nextId = 1;
    private int id;

    private String username;
    private String password;
    private String email;
    private LocalDate dateRegistered; // bonus mission 2

    public User() {
    }
    public User(String username, String password, String email) {
        this.id = nextId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateRegistered = LocalDate.now();
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }
}
