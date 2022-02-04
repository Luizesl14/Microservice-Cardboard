package com.systemorderservice.insfrastructure.service;

import com.systemorderservice.aplicatiton.core.configuration.GenericEntity_;
import com.systemorderservice.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemorderservice.aplicatiton.dto.OrderServiceDto;
import com.systemorderservice.domain.model.OrderService;
import com.systemorderservice.domain.repository.IOrderServiceRepository;
import com.systemorderservice.domain.objectValue.IService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SOrderService implements IService {

    @Autowired
    private  GenericObjectMapper mapper;

    @Autowired
    private IOrderServiceRepository IOrderServiceRepository;


    public Page<OrderServiceDto> bringAll(Integer page, Integer pageSize){
        return this.mapper.mapEntityPageIntoDtoPage(
                this.IOrderServiceRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id"))), OrderServiceDto.class);
    }

    public OrderServiceDto bringByid(Long id){
        OrderService orderService = this.IOrderServiceRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, "ORDEM DE SERVICO - NOT FOUND"));
        return  this.mapper.mapTo(orderService, OrderServiceDto.class);
    }

    public OrderServiceDto saveObject(Object obj){
        OrderServiceDto orderServiceDto =  this.mapper.mapTo(obj, OrderServiceDto.class);
        this.IOrderServiceRepository.save(this.mapper.mapTo(orderServiceDto, OrderService.class));
        return  this.bringByid(orderServiceDto.getId());
    }

    public OrderServiceDto updateObject(Object obj){
        OrderServiceDto orderServiceDto =  this.mapper.mapTo(obj, OrderServiceDto.class);
       OrderService newOrderService =  this.IOrderServiceRepository.save(
               this.mapper.mapTo(orderServiceDto, OrderService.class));

       OrderService serarchOrderService = this.IOrderServiceRepository.findById(orderServiceDto.getId())
               .orElseThrow(()-> new ObjectNotFoundException(orderServiceDto.getId(), "ORDEM DE SERVICO - NOT FOUND"));

        BeanUtils.copyProperties(newOrderService, serarchOrderService, GenericEntity_.ID, GenericEntity_.IDENTIFY,
              GenericEntity_.CREATED_AT, GenericEntity_.DELIVERY_DATE);

        return this.mapper.mapTo(
                this.IOrderServiceRepository.save(newOrderService), OrderServiceDto.class);

    }

    public void deleteObject(Long id){
        this.IOrderServiceRepository.deleteById(id);
    }


}
