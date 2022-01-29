package com.systemorderservice.insfrastructure.service;

import com.systemorderservice.aplicatiton.core.configuration.GenericEntity_;
import com.systemorderservice.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemorderservice.aplicatiton.dto.StatusOrderServiceTypeDto;
import com.systemorderservice.domain.model.StatusOrderServiceType;
import com.systemorderservice.domain.objectValue.IService;
import com.systemorderservice.domain.repository.StatusOrderServiceRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IService {

    @Autowired
    private GenericObjectMapper mapper;
    @Autowired
    private StatusOrderServiceRepository statusOrderServiceRepository;




    public Page<StatusOrderServiceTypeDto> bringAll(Integer page, Integer pageSize){
        return this.mapper.mapEntityPageIntoDtoPage(
                this.statusOrderServiceRepository.findAll(
                        PageRequest.of(page, pageSize, Sort.by("id"))), StatusOrderServiceTypeDto.class);
    }

    public StatusOrderServiceTypeDto bringByid(Long id){
        StatusOrderServiceType status = this.statusOrderServiceRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id,"ORDEM DE SERVICO - NOT FOUND"));
        return  this.mapper.mapTo(status, StatusOrderServiceTypeDto.class);
    }

    public StatusOrderServiceTypeDto saveObject(Object obj){
        StatusOrderServiceTypeDto statusDto =  this.mapper.mapTo(obj, StatusOrderServiceTypeDto.class);
        StatusOrderServiceType newStatus =  this.mapper.mapTo(statusDto, StatusOrderServiceType.class );

        return this.mapper.mapTo(
                this.statusOrderServiceRepository.save(newStatus), StatusOrderServiceTypeDto.class);
    }

    public StatusOrderServiceTypeDto updateObject(Object obj){
        StatusOrderServiceTypeDto statusDto =  this.mapper.mapTo(obj, StatusOrderServiceTypeDto.class);
        StatusOrderServiceType newStatus =  this.statusOrderServiceRepository.save(this.mapper.mapTo(statusDto, StatusOrderServiceType.class));

        StatusOrderServiceType serarchStatus = this.statusOrderServiceRepository.findById(statusDto.getId()).orElseThrow(
               ()-> new ObjectNotFoundException(statusDto.getId(), "ORDEM DE SERVICO - NOT FOUND")
       );

        BeanUtils.copyProperties(newStatus, serarchStatus, GenericEntity_.ID, GenericEntity_.IDENTIFY);
        return this.mapper.mapTo(this.statusOrderServiceRepository.save(newStatus), StatusOrderServiceTypeDto.class) ;

    }

    public void deleteObject(Long id){
        this.statusOrderServiceRepository.deleteById(id);
    }


}
