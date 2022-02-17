package com.systemcontroller.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_deashboard")
public class Deashboard {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @Column(name = "identify", nullable = false)
    private String identify = UUID.randomUUID().toString();

    @Column(name = "quantity_order_service")
    private Integer quantityOrderService;

    @Column(name = "quantity_order_producer")
    private Integer quantityOrderProducer;

    @Column(name = "quantity_worker")
    private Integer quantityWorker;

    @Column(name = "quantity_pending")
    private Integer quantityPending;

    @Column(name = "quantity_lost")
    private Integer quantityLost;

    @Column(name = "quantity_development")
    private Integer quantityDevelopment;

}
