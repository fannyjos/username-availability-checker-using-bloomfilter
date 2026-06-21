package com.example.demo.dto;

public class UsernameResponse {

    private boolean available;

    public UsernameResponse(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}