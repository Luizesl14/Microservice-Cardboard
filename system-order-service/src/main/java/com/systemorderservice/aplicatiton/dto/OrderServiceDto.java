package com.systemorderservice.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderServiceDto extends BoxOrderServiceDto {
    private Long id;
    private String identify;
    private LocalDateTime createdAt;
    private int limtDeliveryDate;
    private LocalDateTime deliveryDate;
    private String socialReason;
    private String name;
    private String cpf;
    private String cnpj;
    private String address;
    private String comments;
    private String boxType;
    private String responsible;
    private String lecture;


    public OrderServiceDto(int length, int width, int height,
                           int valueLenghtCalc, int valueWidthCalc,
                           int valueHeigthCalc, int valueAbaSup,
                           int valueAbaSub, int dilatedLengthOne,
                           int dilatedWidthOne, int dilatedLengthTwo,
                           int dilatedWidthTwo, int dilatedHeight,
                           int diletedAbasSup, int diletedAbasSub) {

        super(length, width, height, valueLenghtCalc, valueWidthCalc,
                valueHeigthCalc, valueAbaSup, valueAbaSub, dilatedLengthOne,
                dilatedWidthOne, dilatedLengthTwo, dilatedWidthTwo,
                dilatedHeight, diletedAbasSup, diletedAbasSub);
    }
}
