package com.systemcontroller.aplicatiton.dto;

import com.systemcontroller.domain.model.Payment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {

    private Integer id;
    private String identify;
    private LocalDateTime createdAt;
    private Payment payment;
    private Boolean isActive;
    private Integer orderServiceId;
}
