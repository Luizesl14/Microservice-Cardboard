package com.systemorderproducer.domain.model.orderProducer;

import com.systemorderproducer.domain.model.box.Box;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ordem_servico")
public class OrderProducer extends Box {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "identify", nullable = false)
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

    public OrderProducer(int length, int width,
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

    public OrderProducer() {

    }
}
