package com.systemorderservice.aplicatiton.dto;

import com.systemorderservice.domain.model.BoxBody;
import com.systemorderservice.domain.model.OrderStatus;
import com.systemorderservice.domain.model.Payment;
import com.systemorderservice.domain.model.enums.BoxType;
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
    private OrderStatus orderStatus;
    private BoxType boxType;
    private String responsible;
    private String serviceGrantor;
    private Payment payment;
    private boolean shippingForProduction;
    private BoxBody boxBody;

    public OrderServiceDto() {
    }

}
