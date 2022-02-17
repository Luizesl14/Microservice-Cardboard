package com.systemcontroller.aplicatiton.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Integer id;
    private String  email;
    private String  password;
    private Boolean  isActive;
}
