package com.systemcontroller.domain.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.systemcontroller.domain.model.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "tb_company")
public class Company {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @Column(name = "identify", nullable = false)
    private String identify = UUID.randomUUID().toString();

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cnpj")
    private String  cnpj;

    @NotNull
    @Column(name = "phone")
    private String  phone;

    @Column(name = "email")
    private String  email;

    @Column(name = "password")
    private String  password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    @NotNull
    @Column(name = "address")
    private String  address;

    @NotNull
    @Column(name = "is_active")
    private Boolean  isActive;
    @NotNull
    @Column(name = "midia")
    private String  midia;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "template_style_id")
    private TemplateStyle  templateStyle;


}
