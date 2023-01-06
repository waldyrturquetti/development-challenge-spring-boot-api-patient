package com.challenge.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BusinessRestrictionException extends RuntimeException{

    public BusinessRestrictionException(String message) {
        super(message);
    }
}
