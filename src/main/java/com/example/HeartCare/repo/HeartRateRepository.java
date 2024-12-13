package com.example.HeartCare.repo;


import com.example.HeartCare.entity.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {

    // Custom query to find all heart rates by patientId
    List<HeartRate> findByPatientId(Long patientId);
}
