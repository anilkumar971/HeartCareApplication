package com.example.HeartCare.service;


import com.example.HeartCare.dto.PatientDTO;
import com.example.HeartCare.entity.Patient;
import com.example.HeartCare.entity.User;
import com.example.HeartCare.repo.PatientRepository;
import com.example.HeartCare.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO) {
        User user = userRepository.findById(patientDTO.getUserId()).orElse(null);
        if (user != null) {
            Patient patient = modelMapper.map(patientDTO, Patient.class);
            patient.setUser(user);
            patient = patientRepository.save(patient);
            return modelMapper.map(patient, PatientDTO.class);
        }
        return null; // Or throw an exception for user not found
    }

    @Override
    public PatientDTO getPatientDetails(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient != null) {
            return modelMapper.map(patient, PatientDTO.class);
        }
        return null;  // Or throw an exception if patient not found
    }

    @Override
    public List<PatientDTO> getPatientsByUser(Long userId) {
        List<Patient> patients = patientRepository.findByUserId(userId);
        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }
}

