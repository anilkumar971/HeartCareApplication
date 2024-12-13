package com.example.HeartCare.service;



import com.example.HeartCare.dto.HeartRateDTO;
import com.example.HeartCare.dto.PatientDTO;
import com.example.HeartCare.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    UserDTO loginUser(String email, String password);
}

