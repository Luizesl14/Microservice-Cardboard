package com.systemorderservice.domain.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Table(name ="status_os_type")
@Entity
public class StatusOrderServiceType {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "identify")
    private String identify = UUID.randomUUID().toString();

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "descriotion")
    private String description;

    @Column(name = "hexa_color")
    private String hexaColor;

    @Column(name = "position")
    private int position;
}
