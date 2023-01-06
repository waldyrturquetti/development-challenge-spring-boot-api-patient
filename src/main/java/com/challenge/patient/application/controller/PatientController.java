package com.challenge.patient.application.controller;

import com.challenge.patient.application.dto.PatientDTO;
import com.challenge.patient.domain.service.PatientRepositoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;


@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientRepositoryService patientService;

    public PatientController(PatientRepositoryService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody @Validated PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.create(patientDTO));
    }

    @GetMapping("/by_email")
    public ResponseEntity<?> getPatientByEmail(@RequestParam @Email String email) {
        return ResponseEntity.ok(patientService.getByEmail(email));
    }
}
