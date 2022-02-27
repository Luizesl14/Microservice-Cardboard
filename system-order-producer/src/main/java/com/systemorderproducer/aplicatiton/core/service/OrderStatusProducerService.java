package com.systemorderproducer.aplicatiton.core.service;

import com.systemorderproducer.domain.shared.GenericEntity_;
import com.systemorderproducer.domain.shared.GenericObjectMapper;
import com.systemorderproducer.aplicatiton.dto.OrderStatusDto;
import com.systemorderproducer.domain.model.OrderProducer;
import com.systemorderproducer.domain.model.OrderStatusProducer;
import com.systemorderproducer.domain.objectValue.IOrderStatusProducerService;
import com.systemorderproducer.insfrastructure.repositories.IOrderStatusProducerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusProducerService implements IOrderStatusProducerService {

    @Autowired
    private  GenericObjectMapper mapper;

    @Autowired
    private IOrderStatusProducerRepository orderStatusProducerRepository;


    public Page<OrderStatusDto> bringAll(Integer page, Integer pageSize){
        return this.mapper.mapEntityPageIntoDtoPage(
                this.orderStatusProducerRepository.findAll(
                        PageRequest.of(page,pageSize, Sort.by("id"))), OrderStatusDto.class);
    }

    public OrderStatusDto bringByid(Integer id){
        OrderStatusProducer orderStatus = this.orderStatusProducerRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id ,"ORDEM DE SERVICO - NÃO ENCONTRADA"));
        return  this.mapper.mapTo(orderStatus, OrderStatusDto.class);
    }

    public OrderStatusDto saveObject(Object obj){
        OrderStatusProducer orderStatus = this.mapper.mapTo(obj, OrderStatusProducer.class);
        this.orderStatusProducerRepository.save(orderStatus);
        return  this.bringByid(orderStatus.getId());
    }

    public OrderStatusDto updateObject(Object obj){
        OrderStatusDto orderStatusDto = this.mapper.mapTo(obj, OrderStatusDto.class);
       OrderStatusProducer newOrderStatus =  this.orderStatusProducerRepository.save(this.mapper.mapTo(orderStatusDto, OrderStatusProducer.class));
        OrderStatusProducer serarchOrderProducer = this.orderStatusProducerRepository
                .findById(orderStatusDto.getId()).orElseThrow(()-> new ObjectNotFoundException(orderStatusDto.getId() ,"ORDEM DE SERVICO - NÃO ENCONTRADA"));
        BeanUtils.copyProperties(newOrderStatus, serarchOrderProducer,
                GenericEntity_.ID,GenericEntity_.IDENTIFY, GenericEntity_.CREATED_AT,GenericEntity_.DELIVERY_DATE);
        return this.mapper.mapTo(
                this.orderStatusProducerRepository.save(newOrderStatus), OrderStatusDto.class);

    }

    public void deleteObject(Integer id){
        this.orderStatusProducerRepository.deleteById(id);
    }

    public OrderProducer creatObject(Object obj) {
        return null;
    }


}
