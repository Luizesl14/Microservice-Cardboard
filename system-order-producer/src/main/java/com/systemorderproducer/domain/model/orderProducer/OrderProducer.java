package com.systemorderproducer.domain.model.orderProducer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_order_producer")
public class OrderProducer{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identify", nullable = false)
    private String identify = UUID.randomUUID().toString();

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @Column(name = "limit_delivery_date")
    private Integer limtDeliveryDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "corporate_name")
    private String corporateName;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "address")
    private String address;

    @Column(name = "comments")
    private String comments;

    @Column(name = "box_type")
    private String boxType;

    @Column(name = "responsible")
    private String responsible;

    @NotNull
    @Column(name = "service_grantor")
    private String serviceGrantor;

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
