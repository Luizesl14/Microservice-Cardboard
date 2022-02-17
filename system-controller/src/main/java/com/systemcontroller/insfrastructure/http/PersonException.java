package com.systemcontroller.insfrastructure.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PersonException extends RuntimeException{
    private static final long seralVersionUID = 1L;
    private final HttpStatus httpStatus;
    public PersonException(final String menssage, HttpStatus httpStatus) {
        super(menssage);
        this.httpStatus = httpStatus;
    }
}
