package com.systemcontroller.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeashboardDto {

    private Integer id;
    private String identify;
    private Integer quantityOrderService;
    private Integer quantityOrderProducer;
    private Integer quantityWorker;
    private Integer quantityPending;
    private Integer quantityLost;
    private Integer quantityDevelopment;
}
