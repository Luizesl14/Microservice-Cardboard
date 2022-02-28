package com.systemorderproducer.insfrastructure.http;

import lombok.Builder;
import lombok.Data;


@Data
@Builder(toBuilder = true)
public class ErrorResponse {
    private String menssage;
    private int httpStatus;
    private long timeStamp;
}
