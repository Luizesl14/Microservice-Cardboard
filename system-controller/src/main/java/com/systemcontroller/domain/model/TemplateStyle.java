package com.systemcontroller.domain.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "tb_template_style")
public class TemplateStyle {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @Column(name = "identify", nullable = false)
    private String identify = UUID.randomUUID().toString();

    @NotNull
    @Column(name = "text_color")
    private String  textColor;

    @NotNull
    @Column(name = "background_color")
    private String  backgroundColor;

}
