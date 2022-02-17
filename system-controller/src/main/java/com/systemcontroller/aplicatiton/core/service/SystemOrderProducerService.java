package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.model.Order;
import com.systemcontroller.domain.objectValue.IControllerService;
import com.systemcontroller.domain.objectValue.ISystemOrderProducerFeignClient;
import com.systemcontroller.insfrastructure.http.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemOrderProducerService implements IControllerService {

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ISystemOrderProducerFeignClient orderProducerFeignClient;


    public Page<OrderDto> bringAll(Integer page, Integer pageSize){
        Page<Object> obj = this.orderProducerFeignClient.findAll(page,pageSize);
        Optional.ofNullable(obj).orElseThrow(()-> new OrderException("Objeto não encontrado", HttpStatus.NOT_FOUND));
        return this.mapper.mapEntityPageIntoDtoPage(obj, OrderDto.class);
    }

    public OrderDto bringByid(Integer id){
        Object obj = this.orderProducerFeignClient.findById(id);
        Optional.ofNullable(obj).orElseThrow(()-> new OrderException("Objeto não encontrado", HttpStatus.NOT_FOUND));
        return  this.mapper.mapTo(obj, OrderDto.class);
    }

    public OrderDto saveObject(Object obj){
        OrderDto orderDto = this.mapper.mapTo(obj, OrderDto.class);
        this.orderProducerFeignClient.save(obj);
        return this.bringByid(orderDto.getId());
    }

    public OrderDto updateObject(Object obj){
        OrderDto orderDto = this.mapper.mapTo(obj, OrderDto.class);
        this.orderProducerFeignClient.update(obj);
        return this.bringByid(orderDto.getId());
    }

    public void deleteObject(Integer id){
        this.orderProducerFeignClient.delete(id);
    }

    public Order creatObject(Object obj) {
        Order order = this.mapper.mapTo(obj, Order.class);
        return order;
    }

}
