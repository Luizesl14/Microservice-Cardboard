package com.systemorderservice.insfrastructure.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OrderServiceException extends RuntimeException{
    private static final long seralVersionUID = 1L;
    private final HttpStatus httpStatus;
    public OrderServiceException(final String menssage, HttpStatus httpStatus) {
        super(menssage);
        this.httpStatus = httpStatus;
    }
}
