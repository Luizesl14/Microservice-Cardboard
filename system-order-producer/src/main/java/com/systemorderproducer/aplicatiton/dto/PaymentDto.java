package com.systemorderproducer.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto {

    private Integer id;
    private String name;
    private String cpf;
    private String payType;
    private String producType;
    private BigDecimal productValue;
    private Boolean  approvedPayment;
}
