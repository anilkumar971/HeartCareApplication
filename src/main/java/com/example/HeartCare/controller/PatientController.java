package com.example.HeartCare.controller;


import com.example.HeartCare.dto.PatientDTO;
import com.example.HeartCare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO createdPatient = patientService.addPatient(patientDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDTO> getPatientDetails(@PathVariable Long patientId) {
        PatientDTO patientDTO = patientService.getPatientDetails(patientId);
        if (patientDTO != null) {
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PatientDTO>> getPatientsByUser(@PathVariable Long userId) {
        List<PatientDTO> patients = patientService.getPatientsByUser(userId);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}

