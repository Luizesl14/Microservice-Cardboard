package com.systemcontroller.aplicatiton.dto;


import com.systemcontroller.domain.model.TemplateStyle;
import com.systemcontroller.domain.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyDto {
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
    private String  midia;
    private TemplateStyle templateStyle;
}
