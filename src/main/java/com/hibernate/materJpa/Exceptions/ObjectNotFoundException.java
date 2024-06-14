package com.hibernate.materJpa.Exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public ObjectNotFoundException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
