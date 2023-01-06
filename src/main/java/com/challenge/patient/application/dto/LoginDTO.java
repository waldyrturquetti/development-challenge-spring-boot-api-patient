package com.challenge.patient.application.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class LoginDTO {

    @Email
    private String email;

    @Size(min = 6)
    private String password;

    private boolean returnSecureToken;

    public LoginDTO(){
        this.returnSecureToken = true;
    }
}
