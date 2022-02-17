package com.systemcontroller.aplicatiton.dto;

import com.systemcontroller.domain.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class PersonDto {

    private Integer id;
    private String identify;
    private String name;
    private String cpf;
    private String  cnpj;
    private String  phone;
    private String  email;
    private String  password;
    private UserType userType;
    private String  address;
    private Boolean  isActive;
}
