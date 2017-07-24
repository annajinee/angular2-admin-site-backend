package com.example.dto;

public final class UserfrntDTO {

    private String username;
    private String password;
    private String name;

    public UserfrntDTO() {
    }

    public UserfrntDTO(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}