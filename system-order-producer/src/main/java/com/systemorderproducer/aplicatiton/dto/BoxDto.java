package com.orderService.aplicatiton.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoxDto {

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
