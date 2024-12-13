package com.example.HeartCare.exception;



public class HeartRateNotFoundException extends RuntimeException {
    public HeartRateNotFoundException(String message) {
        super(message);
    }
}

