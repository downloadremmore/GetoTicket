package com.example.rim.Geto_Ticket.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rim on 26/03/17.
 */

public class User {
    private String username;
    private String email;
    private String phone_number;
    private String photoUrl;
    private Map<String, String> events = new HashMap<>();

    public User() {
    }

    public User(String username, String email, String phone_number, String photoUrl) {
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
        this.photoUrl = photoUrl;
    }

    public Map<String, String> getEvents() {
        return events;
    }

    public void setEvents(Map<String, String> events) {
        this.events = events;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }


}
