package com.challenge.patient.domain.repository;

import com.challenge.patient.domain.model.Address;
import com.challenge.patient.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findAddressByPatient(Patient patient);
}
