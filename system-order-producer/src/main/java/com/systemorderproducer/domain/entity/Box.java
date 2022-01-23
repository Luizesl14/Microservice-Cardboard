package com.systemorderproducer.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class Box {

    @Column(name = "internal_length")
    private int length;

    @Column(name = "internal_width")
    private int width;

    @Column(name = "internal_height")
    private int height;

    @Column(name = "value_lenght_calc")
    private int valueLenghtCalc;

    @Column(name = "value_width_calc")
    private int valueWidthCalc;

    @Column(name = "value_heigth_calc")
    private int valueHeigthCalc;

    @Column(name = "value_aba_sup")
    private int valueAbaSup;

    @Column(name = "value_aba_sub")
    private int valueAbaSub;

    @Column(name = "dilated_length_one")
    private int dilatedLengthOne;

    @Column(name = "dilated_width_one")
    private int dilatedWidthOne;

    @Column(name = "dilated_length_two")
    private int dilatedLengthTwo;

    @Column(name = "dilated_width_two")
    private int dilatedWidthTwo;

    @Column(name = "dilated_heigth")
    private int dilatedHeight;

    @Column(name = "dilated_abas_sup")
    private int diletedAbasSup;

    @Column(name = "dilated_abas_sub")
    private int diletedAbasSub;

    public Box(int length, int width, int height, int valueLenghtCalc,
               int valueWidthCalc, int valueHeigthCalc, int valueAbaSup, int valueAbaSub) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.valueLenghtCalc = valueLenghtCalc;
        this.valueWidthCalc = valueWidthCalc;
        this.valueHeigthCalc = valueHeigthCalc;
        this.valueAbaSup = valueAbaSup;
        this.valueAbaSub = valueAbaSub;

        this.dilatedLengthOne =  (length - valueHeigthCalc);
        this.dilatedWidthOne  = (width + valueWidthCalc);
        this.dilatedLengthTwo = (length + valueLenghtCalc);
        this.dilatedWidthTwo = (width - valueWidthCalc);
        this.diletedAbasSup = Math.floorDiv(dilatedLengthTwo, valueAbaSup);
        this.diletedAbasSub = Math.floorDiv(dilatedLengthTwo, valueAbaSub);
    }

    public Box() {

    }
}
