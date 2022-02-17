package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemcontroller.aplicatiton.dto.OrderServiceDto;
import com.systemcontroller.domain.objectValue.ISystemOrderServiceFeignClient;
import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.model.Order;
import com.systemcontroller.domain.objectValue.IControllerService;
import com.systemcontroller.insfrastructure.http.OrderException;
import com.systemcontroller.insfrastructure.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public class SystemOrderService implements IControllerService {

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ISystemOrderServiceFeignClient orderServiceFeignClient;

    public Page<OrderDto> bringAll(Integer page, Integer pageSize){
        Page<Object> obj = this.orderServiceFeignClient.findAll(page,pageSize);
        Optional.ofNullable(obj).orElseThrow(()-> new OrderException("Objeto não encontrado", HttpStatus.NOT_FOUND));
        return this.mapper.mapEntityPageIntoDtoPage(obj, OrderDto.class);
    }

    public OrderDto bringByid(Integer id){
        Object obj = Flux.just(this.orderServiceFeignClient.findById(id));
        Optional.ofNullable(obj).orElseThrow(()-> new OrderException("Objeto não encontrado", HttpStatus.NOT_FOUND));
        return  this.mapper.mapTo(obj, OrderDto.class);
    }

    public OrderServiceDto saveObject(Object obj){
        return this.mapper.mapTo(this.orderServiceFeignClient.save(obj), OrderServiceDto.class);
    }

    public OrderDto updateObject(Object obj){
        OrderDto orderDto = this.mapper.mapTo(obj, OrderDto.class);
        this.orderServiceFeignClient.update(obj);
        return this.bringByid(orderDto.getId());
    }

    public void deleteObject(Integer id){
        this.orderServiceFeignClient.delete(id);
    }

    public Order creatObject(Object obj) {
        return null;
    }

}
