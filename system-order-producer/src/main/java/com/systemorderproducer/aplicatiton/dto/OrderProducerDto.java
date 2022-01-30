package com.systemorderproducer.aplicatiton.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class OrderProducerDto{


    private Long id;
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
    private String boxType;
    private String responsible;
    private String serviceGrantor;
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer valueLengthCalc;
    private Integer valueWidthCalc;
    private Integer valueHeightCalc;
    private Integer valueAbaSup;
    private Integer valueAbaSub;
    private Integer dilatedLengthOne;
    private Integer dilatedWidthOne;
    private Integer dilatedLengthTwo;
    private Integer dilatedWidthTwo;
    private Integer dilatedHeight;
    private Integer diletedAbasSup;
    private Integer diletedAbasSub;


    public OrderProducerDto() {

    }
}
