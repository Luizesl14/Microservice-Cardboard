package com.systemorderservice.domain.model;


import com.systemorderservice.domain.model.enums.BoxType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ordem_servico")
public class OrderService extends BoxOrderService {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;


    @Column(name = "identify", nullable = false)
    private String identify = UUID.randomUUID().toString();

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_os_type_id")
    private StatusOrderServiceType statusOrderServiceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "box_type")
    private BoxType boxType;


    @Column(name = "responsible")
    private String responsible;

    @Column(name = "lecturer")
    private String lecture;

    @Column(name = "pay_status")
    private boolean payStatus;

    @Column(name = "shipping_for_production")
    private boolean shippingForProduction;


    public OrderService(int length, int width, int height,
                        int valueLenghtCalc, int valueWidthCalc,
                        int valueHeigthCalc, int valueAbaSup,
                        int valueAbaSub, String identify, int limtDeliveryDate, String socialReason,
                        String name, String cpf, String cnpj, String address,
                        String comments, BoxType boxType, StatusOrderServiceType statusOrderServiceType, String responsible, String lecture,
                        boolean payStatus, boolean shippingForProduction ) {
        super(length, width, height, valueLenghtCalc, valueWidthCalc, valueHeigthCalc, valueAbaSup, valueAbaSub);
        this.identify = identify;
        this.createdAt = LocalDateTime.now();
        this.limtDeliveryDate = limtDeliveryDate;
        this.deliveryDate = (createdAt.plusDays(limtDeliveryDate));
        this.socialReason = socialReason;
        this.name = name;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
        this.comments = comments;
        this.boxType = boxType;
        this.statusOrderServiceType = statusOrderServiceType;
        this.responsible = responsible;
        this.lecture = lecture;
        this.payStatus = payStatus;
        this.shippingForProduction =  shippingForProduction;
    }

    public OrderService() {
        super();
    }
}
