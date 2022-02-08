package com.systemorderproducer.aplicatiton.dto;

import com.systemorderproducer.domain.model.enums.BoxType;
import com.systemorderproducer.domain.model.BoxBody;
import com.systemorderproducer.domain.model.OrderStatusProducer;
import com.systemorderproducer.domain.model.Payment;
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
    private OrderStatusProducer orderStatusProducer;
    private BoxType boxType;
    private String responsible;
    private String serviceGrantor;
    private Payment payment;
    private boolean shippingForProduction;
    private BoxBody boxBody;
}
