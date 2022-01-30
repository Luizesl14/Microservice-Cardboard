package com.systemorderproducer.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderProducerDto{

    private Long id;
    private String identify;
    private LocalDateTime createdAt;
    private LocalDateTime limtDeliveryDate;
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

    private int length;
    private int width;
    private int height;
    private int valueLenghtCalc;
    private int valueWidthCalc;
    private int valueHeigthCalc;
    private int valueAbaSup;
    private int valueAbaSub;
    private int dilatedLengthOne;
    private int dilatedWidthOne;
    private int dilatedLengthTwo;
    private int dilatedWidthTwo;
    private int dilatedHeight;
    private int diletedAbasSup;
    private int diletedAbasSub;


}
