package com.systemorderservice.domain.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Table(name ="tb_order_status", schema = "public")
@Entity
public class OrderStatus {

    private static final long serialVersionUID = 1L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name= "id")
    private Integer id;

    @Column(name = "identify")
    private String identify = UUID.randomUUID().toString();

    @Column(name = "statusname")
    private String statusname;

    @Column(name = "description")
    private String description;

    @Column(name = "hexacolor")
    private String hexacolor;

    @Column(name = "position")
    private Integer position;
}
