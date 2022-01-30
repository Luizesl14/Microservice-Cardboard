package com.systemorderproducer.domain.model.box;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class Box {

    @Column(name = "length")
    private Integer length;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "value_lenght_calc")
    private Integer valueLenghtCalc;

    @Column(name = "value_width_calc")
    private Integer valueWidthCalc;

    @Column(name = "value_heigth_calc")
    private Integer valueHeigthCalc;

    @Column(name = "value_aba_sup")
    private Integer valueAbaSup;

    @Column(name = "value_aba_sub")
    private Integer valueAbaSub;

    @Column(name = "dilated_length_one")
    private Integer dilatedLengthOne;

    @Column(name = "dilated_width_one")
    private Integer dilatedWidthOne;

    @Column(name = "dilated_length_two")
    private Integer dilatedLengthTwo;

    @Column(name = "dilated_width_two")
    private Integer dilatedWidthTwo;

    @Column(name = "dilated_heigth")
    private Integer dilatedHeight;

    @Column(name = "dilated_abas_sup")
    private Integer diletedAbasSup;

    @Column(name = "dilated_abas_sub")
    private Integer diletedAbasSub;

    public Box(Integer length, Integer width, Integer height, Integer valueLenghtCalc,
               Integer valueWidthCalc, Integer valueHeigthCalc, Integer valueAbaSup,
               Integer valueAbaSub, Integer dilatedLengthOne, Integer dilatedWidthOne,
               Integer dilatedLengthTwo, Integer dilatedWidthTwo, Integer dilatedHeight,
               Integer diletedAbasSup, Integer diletedAbasSub) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.valueLenghtCalc = valueLenghtCalc;
        this.valueWidthCalc = valueWidthCalc;
        this.valueHeigthCalc = valueHeigthCalc;
        this.valueAbaSup = valueAbaSup;
        this.valueAbaSub = valueAbaSub;
        this.dilatedLengthOne = dilatedLengthOne;
        this.dilatedWidthOne = dilatedWidthOne;
        this.dilatedLengthTwo = dilatedLengthTwo;
        this.dilatedWidthTwo = dilatedWidthTwo;
        this.dilatedHeight = dilatedHeight;
        this.diletedAbasSup = diletedAbasSup;
        this.diletedAbasSub = diletedAbasSub;
    }

    public Box() {
    }

}
