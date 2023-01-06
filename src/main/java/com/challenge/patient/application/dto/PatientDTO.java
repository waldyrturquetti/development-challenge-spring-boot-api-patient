package com.challenge.patient.application.dto;

import com.challenge.patient.domain.model.Patient;
import com.challenge.patient.domain.model.PatientStatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class PatientDTO {

    @Nullable
    private Long id;

    @NotBlank
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Email
    private String email;

    @Nullable
    private PatientStatus patientStatus;

    @NotNull
    @Valid
    @JsonAlias("address")
    private AddressDTO addressDTO;

    public Patient convertToModel() {
        return Patient.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .patientStatus(this.patientStatus == null ? PatientStatus.ALIVE : this.patientStatus)
                .birthDate(this.birthDate)
                .build();
    }
}