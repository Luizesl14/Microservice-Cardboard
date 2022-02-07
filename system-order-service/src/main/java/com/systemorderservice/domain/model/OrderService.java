package com.systemorderservice.domain.model;


import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "tb_order_service", schema = "public")
public class OrderService{

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @Column(name = "identify", nullable = false)
    private String identify = UUID.randomUUID().toString();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "box_type")
    private BoxType boxType;

    @Column(name = "responsible")
    private String responsible;

    @Column(name = "service_grantor")
    private String serviceGrantor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "shipping_for_production")
    private boolean shippingForProduction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "box_body_id")
    private BoxBody boxBody;

    public OrderService(){}

    public OrderService(Integer id, String identify, LocalDateTime createdAt,
                        Integer limtDeliveryDate, LocalDateTime deliveryDate,
                        String corporateName, String name, String cpf, String cnpj,
                        String address, String comments, OrderStatus orderStatus,
                        BoxType boxType, String responsible, String serviceGrantor,
                        Payment payment, boolean shippingForProduction, BoxBody boxBody) {
        this.id = id;
        this.identify = identify;
        this.createdAt = createdAt;
        this.limtDeliveryDate = limtDeliveryDate;
        this.deliveryDate = deliveryDate;
        this.corporateName = corporateName;
        this.name = name;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
        this.comments = comments;
        this.orderStatus = orderStatus;
        this.boxType = boxType;
        this.responsible = responsible;
        this.serviceGrantor = serviceGrantor;
        this.payment = payment;
        this.shippingForProduction = shippingForProduction;
        this.boxBody = boxBody;
    }
}
