package com.systemorderservice.aplicatiton.core.service;

import com.systemorderservice.aplicatiton.core.configuration.GenericEntity_;
import com.systemorderservice.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemorderservice.aplicatiton.dto.OrderStatusDto;
import com.systemorderservice.domain.model.OrderStatus;
import com.systemorderservice.domain.objectValue.IService;
import com.systemorderservice.insfrastructure.repository.StatusOrderServiceRepository;
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




    public Page<OrderStatusDto> bringAll(Integer page, Integer pageSize){
        return this.mapper.mapEntityPageIntoDtoPage(
                this.statusOrderServiceRepository.findAll(
                        PageRequest.of(page, pageSize, Sort.by("id"))), OrderStatusDto.class);
    }

    public OrderStatusDto bringByid(Integer id){
        OrderStatus status = this.statusOrderServiceRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id,"ORDEM DE SERVICO - NOT FOUND"));
        return  this.mapper.mapTo(status, OrderStatusDto.class);
    }

    public OrderStatusDto saveObject(Object obj){
        OrderStatusDto statusDto =  this.mapper.mapTo(obj, OrderStatusDto.class);
        OrderStatus newStatus =  this.mapper.mapTo(statusDto, OrderStatus.class );

        return this.mapper.mapTo(
                this.statusOrderServiceRepository.save(newStatus), OrderStatusDto.class);
    }

    public OrderStatusDto updateObject(Object obj){
        OrderStatusDto statusDto =  this.mapper.mapTo(obj, OrderStatusDto.class);
        OrderStatus newStatus =  this.statusOrderServiceRepository.save(this.mapper.mapTo(statusDto, OrderStatus.class));

        OrderStatus serarchStatus = this.statusOrderServiceRepository.findById(statusDto.getId()).orElseThrow(
               ()-> new ObjectNotFoundException(statusDto.getId(), "ORDEM DE SERVICO - NOT FOUND")
       );

        BeanUtils.copyProperties(newStatus, serarchStatus, GenericEntity_.ID, GenericEntity_.IDENTIFY);
        return this.mapper.mapTo(this.statusOrderServiceRepository.save(newStatus), OrderStatusDto.class) ;

    }

    public void deleteObject(Integer id){
        this.statusOrderServiceRepository.deleteById(id);
    }

    public boolean postObject(Object o) {
        return false;
    }

    @Override
    public Object creatObject(Object o) {
        return null;
    }


}
