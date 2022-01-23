package com.orderService.aplicatiton.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
public class OsOsDto extends BoxOsDto {

    private Long id;
    private String identify;
    private LocalDateTime createdAt;
    private int limtDeliveryDate;
    private LocalDateTime deliveryDate;
    private String socialReason;
    private String name;
    private String cpf;
    private String cnpj;
    private String address;
    private String comments;
    private String boxType;
    private String responsible;
    private String lecture;
}
