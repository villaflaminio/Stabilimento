package com.flaminiovilla.stabilimento.security.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    public String email;
    public String password;
    public String role;
    public String firstName;
    public String lastName;
    public String phone;
}