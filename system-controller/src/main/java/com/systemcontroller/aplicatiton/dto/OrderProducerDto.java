package com.systemcontroller.aplicatiton.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.systemcontroller.domain.model.Payment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderProducerDto{

    private Integer id;
    private String identify;
    private LocalDateTime createdAt;
    private Integer limtDeliveryDate;
    private LocalDateTime deliveryDate;
    private String corporateName;
    private String name;
    private String cpf;
    private String cnpj;
    private String address;
    private String comments;
    private OrderStatusDto orderStatusProducer;
    @JsonDeserialize
    private String boxType;
    private String responsible;
    private String serviceGrantor;
    private Payment payment;
    private boolean shippingForProduction;
    private BoxBodyDto boxBody;

    public OrderProducerDto() {
    }
}
