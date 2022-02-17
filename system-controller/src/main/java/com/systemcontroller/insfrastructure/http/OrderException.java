package com.systemcontroller.insfrastructure.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OrderException extends RuntimeException{
    private static final long seralVersionUID = 1L;
    private final HttpStatus httpStatus;
    public OrderException(final String menssage, HttpStatus httpStatus) {
        super(menssage);
        this.httpStatus = httpStatus;
    }
}
