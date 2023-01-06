package com.challenge.patient.domain.service;

import com.challenge.patient.application.dto.LoginDTO;

import java.io.IOException;

public interface LoginService extends Service{

    Object login(LoginDTO loginDTO) throws IOException;
}
