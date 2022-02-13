package com.systemorderservice.insfrastructure.http;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
public class Response<T> extends RepresentationModel<Response<T>> {
    private int statusCode;
    private T data;
}