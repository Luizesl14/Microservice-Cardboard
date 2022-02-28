package com.systemorderproducer.insfrastructure.http;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OrderProducerException extends RuntimeException{
    private static final long seralVersionUID = 1L;
    private final HttpStatus httpStatus;
    public OrderProducerException(final String menssage, HttpStatus httpStatus) {
        super(menssage);
        this.httpStatus = httpStatus;
    }
}
