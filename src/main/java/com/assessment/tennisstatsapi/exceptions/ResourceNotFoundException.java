package com.assessment.tennisstatsapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
	    value = HttpStatus.NOT_FOUND, 
	    reason = "Requested player does not exist"
	)

public class ResourceNotFoundException extends RuntimeException {

	
    public ResourceNotFoundException(String s) {
        super(s);
    }
}
