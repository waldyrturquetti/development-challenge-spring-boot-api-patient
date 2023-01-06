package com.challenge.patient.application.controller;

import com.challenge.patient.application.dto.LoginDTO;
import com.challenge.patient.domain.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Validated LoginDTO loginDTO) throws IOException {
        return ResponseEntity.ok(this.loginService.login(loginDTO));
    }
}
