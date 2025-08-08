package dev.proj.patientservice.service.impl;

import dev.proj.patientservice.dto.response.PatientResponseDTO;
import dev.proj.patientservice.mapper.PatientMapper;
import dev.proj.patientservice.model.Patient;
import dev.proj.patientservice.repository.PatientRepository;
import dev.proj.patientservice.service.PatientService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patientMapper.toPatientResponseDTOs(patients);
    }
}
