package com.example.HeartCare.service;

import com.example.HeartCare.dto.HeartRateDTO;
import com.example.HeartCare.entity.HeartRate;
import com.example.HeartCare.entity.Patient;
import com.example.HeartCare.repo.HeartRateRepository;
import com.example.HeartCare.repo.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeartRateServiceImpl implements HeartRateService {



    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HeartRateDTO recordHeartRate(HeartRateDTO heartRateDTO) {
        Patient patient = patientRepository.findById(heartRateDTO.getPatientId()).orElse(null);
        if (patient != null) {
            HeartRate heartRate = modelMapper.map(heartRateDTO, HeartRate.class);
            heartRate.setPatient(patient);
            heartRate = heartRateRepository.save(heartRate);
            return modelMapper.map(heartRate, HeartRateDTO.class);
        }
        return null; // Or throw an exception if patient not found
    }

    @Override
    public List<HeartRateDTO> getHeartRatesByPatient(Long patientId) {
        List<HeartRate> heartRates = heartRateRepository.findByPatientId(patientId);
        return heartRates.stream()
                .map(heartRate -> modelMapper.map(heartRate, HeartRateDTO.class))
                .collect(Collectors.toList());
    }

}

