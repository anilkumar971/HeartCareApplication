package com.example.HeartCare.controller;


import com.example.HeartCare.dto.HeartRateDTO;
import com.example.HeartCare.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heart-rates")
public class HeartRateController {

    @Autowired
    private HeartRateService heartRateService;

    @PostMapping("/record")
    public ResponseEntity<HeartRateDTO> recordHeartRate(@RequestBody HeartRateDTO heartRateDTO) {
        HeartRateDTO recordedHeartRate = heartRateService.recordHeartRate(heartRateDTO);
        return new ResponseEntity<>(recordedHeartRate, HttpStatus.CREATED);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HeartRateDTO>> getHeartRatesByPatient(@PathVariable Long patientId) {
        List<HeartRateDTO> heartRates = heartRateService.getHeartRatesByPatient(patientId);
        return new ResponseEntity<>(heartRates, HttpStatus.OK);
    }
}

