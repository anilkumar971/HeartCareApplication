package com.example.HeartCare.service;



import com.example.HeartCare.dto.HeartRateDTO;

import java.util.List;

public interface HeartRateService {

    HeartRateDTO recordHeartRate(HeartRateDTO heartRateDTO);

    List<HeartRateDTO> getHeartRatesByPatient(Long patientId);
}

