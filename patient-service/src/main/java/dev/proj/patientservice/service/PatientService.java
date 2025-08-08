package dev.proj.patientservice.service;

import dev.proj.patientservice.dto.request.PatientRequestDTO;
import dev.proj.patientservice.dto.response.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    List<PatientResponseDTO> getPatients();
    PatientResponseDTO createPatient(PatientRequestDTO  patientRequestDTO);
}
