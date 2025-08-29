package dev.proj.patientservice.service;

import dev.proj.patientservice.dto.request.PatientRequestDTO;
import dev.proj.patientservice.dto.response.PatientResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<PatientResponseDTO> getPatients();

    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);

    PatientResponseDTO updatePatient(UUID uuid, PatientRequestDTO patientRequestDTO);

    void deletePatient(UUID uuid);
}
