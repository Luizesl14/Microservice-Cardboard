package com.systemorderservice.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusOsTypeDto {

    private Long id;
    private String identify;
    private String statusName;
    private String description;
    private String hexaColor;
    private int position;
}
