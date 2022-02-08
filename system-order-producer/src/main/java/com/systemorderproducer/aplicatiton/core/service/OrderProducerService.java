package com.systemorderproducer.aplicatiton.core.service;

import com.systemorderproducer.aplicatiton.core.configuration.GenericEntity_;
import com.systemorderproducer.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemorderproducer.aplicatiton.dto.OrderProducerDto;
import com.systemorderproducer.domain.model.OrderProducer;
import com.systemorderproducer.domain.objectValue.IOrderProducerService;
import com.systemorderproducer.insfrastructure.repositories.IOrderProducerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class OrderProducerService implements IOrderProducerService {

    @Autowired
    private  GenericObjectMapper mapper;

    @Autowired
    private IOrderProducerRepository IOrderProducerRepository;


    public Page<OrderProducerDto> bringAll(Integer page, Integer pageSize){
        return this.mapper.mapEntityPageIntoDtoPage(
                this.IOrderProducerRepository.findAll(
                        PageRequest.of(page,pageSize, Sort.by("id"))), OrderProducerDto.class);
    }

    public OrderProducerDto bringByid(Integer id){
        OrderProducer orderProducer = this.IOrderProducerRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id ,"ORDEM DE SERVICO - NÃO ENCONTRADA"));
        return  this.mapper.mapTo(orderProducer, OrderProducerDto.class);
    }

    public OrderProducerDto saveObject(Object obj){
        OrderProducer orderProducer = this.creatObject(obj);
        this.IOrderProducerRepository.save(orderProducer);
        return  this.bringByid(orderProducer.getId());
    }

    public OrderProducerDto updateObject(Object obj){
        OrderProducerDto orderProducerDto = this.mapper.mapTo(obj, OrderProducerDto.class);
       OrderProducer newOrderProducer =  this.IOrderProducerRepository.save(
               this.mapper.mapTo(orderProducerDto, OrderProducer.class));
       OrderProducer serarchOrderProducer = this.IOrderProducerRepository.findById(
               orderProducerDto.getId()).orElseThrow(()->
               new ObjectNotFoundException(orderProducerDto.getId() ,"ORDEM DE SERVICO - NÃO ENCONTRADA"));

        BeanUtils.copyProperties(newOrderProducer, serarchOrderProducer,
                GenericEntity_.ID,GenericEntity_.IDENTIFY, GenericEntity_.CREATED_AT,GenericEntity_.DELIVERY_DATE);
        return this.mapper.mapTo(
                this.IOrderProducerRepository.save(newOrderProducer), OrderProducerDto.class);

    }

    public void deleteObject(Integer id){
        this.IOrderProducerRepository.deleteById(id);
    }

    public OrderProducer creatObject(Object obj) {
        OrderProducer orderProducer = this.mapper.mapTo(obj, OrderProducer.class);
        orderProducer.setCreatedAt(LocalDateTime.now());
        orderProducer.setDeliveryDate(LocalDateTime.now().plusDays(orderProducer.getLimtDeliveryDate()));
        return orderProducer;
    }


}
