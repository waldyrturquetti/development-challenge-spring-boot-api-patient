package com.challenge.patient.domain.service;

import com.challenge.patient.domain.model.Address;
import com.challenge.patient.domain.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressRepositoryServiceImpl implements AddressRepositoryService {

    private final AddressRepository addressRepository;

    public AddressRepositoryServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) { return addressRepository.save(address); }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
