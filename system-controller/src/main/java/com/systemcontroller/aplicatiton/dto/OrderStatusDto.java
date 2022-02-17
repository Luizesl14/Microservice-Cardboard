package com.systemcontroller.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusDto {

    private Integer id;
    private String identify;
    private String statusName;
    private String description;
    private String hexaColor;
    private int position;
}
