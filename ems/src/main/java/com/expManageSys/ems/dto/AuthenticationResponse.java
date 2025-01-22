package com.expManageSys.ems.dto;

public class AuthenticationResponse {
    private String jwt;

    // Default constructor
    public AuthenticationResponse() {}

    // Parameterized constructor
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    // Getter
    public String getJwt() {
        return jwt;
    }

    // Setter
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}