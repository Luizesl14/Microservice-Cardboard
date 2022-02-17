package com.systemcontroller.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_order")
public class Order {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @Column(name = "identify", nullable = false)
    private String identify = UUID.randomUUID().toString();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotBlank(message = "Informe um dados do pagamento")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @NotNull
    @Column(name = "is_active")
    private Boolean  isActive;

    @Column(name = "order_service_id")
    private Integer  orderServiceId;
}
