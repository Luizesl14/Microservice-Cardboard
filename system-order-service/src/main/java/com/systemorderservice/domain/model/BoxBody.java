package com.systemorderservice.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "tb_box_body", schema = "public")
public class BoxBody {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @NotNull
    @Column(name = "length")
    private Integer length;

    @NotNull
    @Column(name = "width")
    private Integer width;

    @NotNull
    @Column(name = "height")
    private Integer height;

    @NotNull
    @Column(name = "value_length_calc")
    private Integer valueLengthCalc;

    @NotNull
    @Column(name = "value_width_calc")
    private Integer valueWidthCalc;

    @NotNull
    @Column(name = "value_height_calc")
    private Integer valueHeightCalc;

    @Column(name = "value_aba_sup")
    private Integer valueAbaSup;

    @Column(name = "value_aba_sub")
    private Integer valueAbaSub;

    @Column(name = "dilated_length_one")
    private Integer dilatedLengthOne ;

    @Column(name = "dilated_width_one")
    private Integer dilatedWidthOne;

    @Column(name = "dilated_length_two")
    private Integer dilatedLengthTwo ;

    @Column(name = "dilated_width_two")
    private Integer dilatedWidthTwo;

    @Column(name = "dilated_height")
    private Integer dilatedHeight;

    @Column(name = "dilated_abas_sup")
    private Integer diletedAbasSup;

    @Column(name = "dilated_abas_sub")
    private Integer diletedAbasSub;

}
