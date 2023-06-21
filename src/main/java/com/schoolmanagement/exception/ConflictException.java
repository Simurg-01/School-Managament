package com.schoolmanagement.exception;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}
