package com.challenge.patient.domain.model;

import com.challenge.patient.application.dto.PatientDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PatientStatus patientStatus;

    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    public PatientDTO convertToDTO() {
        return PatientDTO.builder()
                .id(this.id)
                .name(this.name)
                .patientStatus(this.patientStatus)
                .birthDate(this.birthDate)
                .email(this.email)
                .addressDTO(this.address.convertToDTO())
                .build();
    }
}
