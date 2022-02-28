package com.systemorderservice.aplicatiton.core.service;

import com.systemorderservice.aplicatiton.dto.OrderStatusDto;
import com.systemorderservice.domain.model.OrderStatus;
import com.systemorderservice.domain.objectValue.valueExtends.IOrderStatusService;
import com.systemorderservice.domain.shared.GenericEntity_;
import com.systemorderservice.domain.shared.GenericObjectMapper;
import com.systemorderservice.insfrastructure.repository.IStatusOrderServiceRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IOrderStatusService {

    @Autowired
    private GenericObjectMapper mapper;
    @Autowired
    private IStatusOrderServiceRepository statusOrderServiceRepository;




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

    public OrderStatusDto updateObject(OrderStatusDto orderStatusDto){
        OrderStatus newStatus = this.mapper.mapTo(orderStatusDto, OrderStatus.class);
        OrderStatus serarchStatus =
                this.mapper.mapTo(this.bringByid(newStatus.getId()), OrderStatus.class);

        BeanUtils.copyProperties(newStatus, serarchStatus, GenericEntity_.ID, GenericEntity_.IDENTIFY);
        return this.mapper.mapTo(this.statusOrderServiceRepository.save(newStatus), OrderStatusDto.class) ;
    }


    public void deleteObject(Integer id){
        this.statusOrderServiceRepository.deleteById(id);
    }



}
