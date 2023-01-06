package com.challenge.patient.domain.service;

import com.challenge.patient.application.dto.PatientDTO;
import com.challenge.patient.domain.model.PatientStatus;

public interface PatientRepositoryService extends RepositoryService<PatientDTO> {

    PatientDTO getByEmail(String email);

    PatientDTO changePatientStatus(Long id, PatientStatus patientStatus);
}
