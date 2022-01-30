package com.systemorderproducer.domain.model.orderProducer;

import com.systemorderproducer.domain.model.box.Box;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_order_producer")
public class OrderProducer extends Box {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identify")
    private String identify = UUID.randomUUID().toString();

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "limit_delivery_date")
    private LocalDateTime limtDeliveryDate;

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

    @Column(name = "service_grantor")
    private String serviceGrantor;

    public OrderProducer(Integer length, Integer width, Integer height,
                         Integer valueLenghtCalc, Integer valueWidthCalc,
                         Integer valueHeigthCalc, Integer valueAbaSup,
                         Integer valueAbaSub, Integer dilatedLengthOne,
                         Integer dilatedWidthOne, Integer dilatedLengthTwo,
                         Integer dilatedWidthTwo, Integer dilatedHeight,
                         Integer diletedAbasSup, Integer diletedAbasSub, LocalDateTime deliveryDate,
                         String corporateName, String name, String cpf, String cnpj,
                         String address, String comments, String boxType,
                         String responsible, String serviceGrantor)
    {
        super(length, width, height, valueLenghtCalc, valueWidthCalc,
                valueHeigthCalc, valueAbaSup, valueAbaSub, dilatedLengthOne,
                dilatedWidthOne, dilatedLengthTwo, dilatedWidthTwo, dilatedHeight,
                diletedAbasSup, diletedAbasSub);

        this.deliveryDate = deliveryDate;
        this.corporateName = corporateName;
        this.name = name;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
        this.comments = comments;
        this.boxType = boxType;
        this.responsible = responsible;
        this.serviceGrantor = serviceGrantor;
    }

    public OrderProducer() {
    }
}
