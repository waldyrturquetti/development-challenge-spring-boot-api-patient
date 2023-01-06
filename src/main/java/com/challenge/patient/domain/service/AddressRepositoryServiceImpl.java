package com.challenge.patient.domain.service;

import com.challenge.patient.domain.model.Address;
import com.challenge.patient.domain.model.Patient;
import com.challenge.patient.domain.repository.AddressRepository;
import com.challenge.patient.exception.BusinessRestrictionException;
import org.springframework.stereotype.Service;

@Service
public class AddressRepositoryServiceImpl implements AddressRepositoryService {

    private final AddressRepository addressRepository;

    public AddressRepositoryServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddressByPatient(Patient patient) {
        return addressRepository.findAddressByPatient(patient)
                .orElseThrow(() -> new BusinessRestrictionException("This patient don't have address."));
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address entity) { return null; }

    @Override
    public void delete(Long id) {}
}
