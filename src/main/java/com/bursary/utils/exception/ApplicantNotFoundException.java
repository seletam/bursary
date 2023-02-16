package com.bursary.utils.exception;

import lombok.Getter;

@Getter
public class ApplicantNotFoundException extends RuntimeException {
    private final String message;
    public ApplicantNotFoundException(String message) {
        this.message = message;
    }
}
