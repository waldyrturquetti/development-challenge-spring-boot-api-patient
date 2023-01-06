package com.challenge.patient.domain.service;

import com.challenge.patient.application.dto.PatientDTO;
import com.challenge.patient.domain.model.Address;
import com.challenge.patient.domain.model.Patient;
import com.challenge.patient.domain.repository.PatientRepository;
import com.challenge.patient.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientRepositoryServiceImpl implements PatientRepositoryService {

    private final PatientRepository patientRepository;
    private final AddressRepositoryService addressService;

    public PatientRepositoryServiceImpl(PatientRepository patientRepository, AddressRepositoryService addressService) {
        this.patientRepository = patientRepository;
        this.addressService = addressService;
    }

    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        Patient patient = patientRepository.save(patientDTO.convertToModel());
        patient.setAddress(addressService.create(patientDTO.getAddressDTO().convertToModel(patient)));
        return patient.convertToDTO();
    }

    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        Patient patient = patientRepository.save(patientDTO.convertToModel());
        patient.setAddress(addressService.update(patientDTO.getAddressDTO().convertToModel(patient)));
        return patient.convertToDTO();
    }

    @Override
    public void delete(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found the Patient."));
        addressService.delete(patient.getAddress().getId());
        patientRepository.delete(patient);
    }

    @Override
    public PatientDTO getByEmail(String email) {
        Patient patient = patientRepository.findPatientByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Not found patient by email."));
        return patient.convertToDTO();
    }
}
