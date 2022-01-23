package com.systemorderproducer.aplicatiton.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@MappedSuperclass
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String identify;

    @JsonIgnore
    @Transient
    private String createdAt;

    @JsonIgnore
    @Transient
    private LocalDateTime deliveryDate;

}