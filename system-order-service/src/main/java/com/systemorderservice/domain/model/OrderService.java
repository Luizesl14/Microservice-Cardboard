package com.systemorderservice.domain.model;


import com.systemorderservice.domain.model.enums.BoxType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_order_service", schema = "public")
public class OrderService implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @Column(name = "identify", nullable = false)
    private String identify;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "limit_delivery_date")
    private Integer limtDeliveryDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @NotNull(message = "Informe nome da corporação")
    @Column(name = "corporate_name")
    private String corporateName;

    @NotNull(message = "Informe nome")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Informe seu CPF")
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String cnpj;

    @NotNull(message = "Informe seu endereço")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Informe um comentário")
    @Column(name = "comments")
    private String comments;

    @NotNull(message = "Informe um status")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @NotNull(message = "Informe um tipo de caixa")
    @Enumerated(EnumType.STRING)
    @Column(name = "box_type")
    private BoxType boxType;

    @NotNull(message = "Informe um responsável")
    @Column(name = "responsible")
    private String responsible;

    @NotNull(message = "Informe um conferente")
    @Column(name = "service_grantor")
    private String serviceGrantor;

    @NotBlank(message = "Informe um dados do pagamento")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "shipping_for_production")
    private boolean shippingForProduction;

    @NotBlank(message = "Informe um todas as medida da caixa")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "box_body_id")
    private BoxBody boxBody;

}
