package com.example.HeartCare.repo;


import com.example.HeartCare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Custom query to find a patient by userId
   // Patient findByUserId(Long userId);
    //List<Patient> findByUserId(Long userId);
    @Query("SELECT DISTINCT p FROM Patient p WHERE p.user.id = :userId")
    List<Patient> findByUserId(@Param("userId") Long userId);

}

