package dev.proj.patientservice.mapper;

import dev.proj.patientservice.dto.response.PatientResponseDTO;
import dev.proj.patientservice.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    public PatientResponseDTO toPatientResponseDTO(Patient patient) {
        return new PatientResponseDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getBirthDate(),
                patient.getRegisteredDate()
        );
    }

    public List<PatientResponseDTO> toPatientResponseDTOs(List<Patient> patients) {
        return patients.stream()
                .map(this::toPatientResponseDTO)
                .toList();
    }
}
