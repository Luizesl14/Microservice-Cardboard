package com.systemcontroller.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderServiceDto{

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
    private OrderStatusDto orderStatus;
    private String responsible;
    private String serviceGrantor;
    private PaymentDto payment;
    private boolean shippingForProduction;
    private BoxBodyDto boxBody;

    public OrderServiceDto() {
    }

}
