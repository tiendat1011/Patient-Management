package dev.proj.patientservice.dto.response;

import dev.proj.patientservice.model.Patient;

import java.time.LocalDate;
import java.util.UUID;

public record PatientResponseDTO(
        UUID id,
        String name,
        String email,
        String address,
        LocalDate birthDate,
        LocalDate registeredDate
) { }
