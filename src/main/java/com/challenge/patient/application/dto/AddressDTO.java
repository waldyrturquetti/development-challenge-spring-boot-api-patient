package com.challenge.patient.application.dto;

import com.challenge.patient.domain.model.Address;
import com.challenge.patient.domain.model.Patient;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
public class AddressDTO {

    @Nullable
    private Long id;

    @NotBlank
    private String street;

    @NotNull
    private Integer number;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    @Pattern(regexp = "[A-Z]{2}")
    @Size(min = 2, max = 2)
    private String state;

    @Nullable
    private String complement;

    public Address convertToModel(Patient patient) {
        return Address.builder()
                .street(this.street)
                .number(this.number)
                .district(this.district)
                .city(this.city)
                .state(this.state)
                .complement(this.complement)
                .patient(patient)
                .build();
    }
}
