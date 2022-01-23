package com.systemorderservice.domain.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table(name ="status_os_type")
@Entity
public class StatusOsType {

    @Id
    @Column(name = "identify")
    private String identify;

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "descriotion")
    private String description;

    @Column(name = "hexa_color")
    private String hexaColor;

    @Column(name = "position")
    private int position;
}
