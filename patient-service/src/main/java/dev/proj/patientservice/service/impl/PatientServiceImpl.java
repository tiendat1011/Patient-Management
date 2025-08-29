package dev.proj.patientservice.service.impl;

import dev.proj.patientservice.dto.request.PatientRequestDTO;
import dev.proj.patientservice.dto.response.PatientResponseDTO;
import dev.proj.patientservice.exception.EmailAlreadyExistsException;
import dev.proj.patientservice.exception.PatientNotFoundException;
import dev.proj.patientservice.mapper.PatientMapper;
import dev.proj.patientservice.model.Patient;
import dev.proj.patientservice.repository.PatientRepository;
import dev.proj.patientservice.service.PatientService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patientMapper.toPatientResponseDTOs(patients);
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.email())) {
            throw new EmailAlreadyExistsException(patientRequestDTO.email() + "| This email already exists");
        }

        Patient newPatient = Patient.builder()
                .name(patientRequestDTO.name())
                .address(patientRequestDTO.address())
                .email(patientRequestDTO.email())
                .birthDate(patientRequestDTO.birthDate())
                .registeredDate(LocalDate.now())
                .build();

        return patientMapper.toPatientResponseDTO(patientRepository.save(newPatient));
    }

    @Override
    public PatientResponseDTO updatePatient(UUID uuid, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(uuid).orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + uuid));

        patient.setName(patientRequestDTO.name());
        patient.setAddress(patientRequestDTO.address());
        patient.setEmail(patientRequestDTO.email());
        patient.setBirthDate(patientRequestDTO.birthDate());

        Patient updatedPatient = patientRepository.save(patient);
        return patientMapper.toPatientResponseDTO(updatedPatient);
    }
}
