package com.challenge.patient.domain.model;

import com.challenge.patient.application.dto.AddressDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String street;

    @NotNull
    @Column(nullable = false)
    private Integer number;

    @NotBlank
    @Column(nullable = false)
    private String district;

    @Column
    private String complement;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @OneToOne
    @JoinColumn(name = "fk_patient_id", referencedColumnName = "id", nullable = false)
    private Patient patient;

    public AddressDTO convertToDTO() {
        return AddressDTO.builder()
                .id(this.id)
                .street(this.street)
                .number(this.number)
                .district(this.district)
                .state(this.state)
                .city(this.city)
                .complement(this.complement)
        .build();
    }
}
