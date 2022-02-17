package com.systemcontroller.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.systemcontroller.domain.model.enums.BoxType;
import com.systemcontroller.domain.model.enums.PayType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "tb_payment")
public class Payment {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cpf")
    private String cpf;


    @Enumerated(EnumType.STRING)
    @Column(name = "pay_type")
    private PayType payType;


    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private BoxType producType;


    @Column(name = "product_value")
    private float productValue;

    @NotNull
    @Column(name = "approved_payment")
    private Boolean  approvedPayment;
}
