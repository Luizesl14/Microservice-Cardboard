package com.systemorderproducer.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ordem_servico")
public class Op extends Box {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "identify")
    private String identify;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "limit_delivery_date")
    private int limtDeliveryDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "social_reason")
    private String socialReason;

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

    @Column(name = "lecturer")
    private String lecture;

    public Op(int length, int width,
              int height, int valueLenghtCalc,
              int valueWidthCalc, int valueHeigthCalc,
              int valueAbaSup, int valueAbaSub, Long id,
              String identify, LocalDateTime createdAt,
              int limtDeliveryDate, LocalDateTime deliveryDate,
              String socialReason, String name, String cpf,
              String cnpj, String address, String comments,
              String boxType, String responsible, String lecture) {
        super(length, width, height, valueLenghtCalc,
                valueWidthCalc, valueHeigthCalc,
                valueAbaSup, valueAbaSub);
        this.id = id;
        this.identify = identify;
        this.createdAt = createdAt;
        this.limtDeliveryDate = limtDeliveryDate;
        this.deliveryDate = deliveryDate;
        this.socialReason = socialReason;
        this.name = name;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
        this.comments = comments;
        this.boxType = boxType;
        this.responsible = responsible;
        this.lecture = lecture;
    }

    public Op() {

    }
}
