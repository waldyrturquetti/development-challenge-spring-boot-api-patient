package com.challenge.patient.domain.service;

import com.challenge.patient.application.dto.PatientDTO;

public interface PatientRepositoryService extends RepositoryService<PatientDTO> {

    PatientDTO getByEmail(String email);
}
