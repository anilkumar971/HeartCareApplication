package com.example.HeartCare.service;



import com.example.HeartCare.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO addPatient(PatientDTO patientDTO);

    PatientDTO getPatientDetails(Long patientId);

    List<PatientDTO> getPatientsByUser(Long userId);
}
