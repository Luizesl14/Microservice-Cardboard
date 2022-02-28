package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.dto.OrderServiceDto;
import com.systemcontroller.domain.objectValue.ISystemOrderServiceFeignClient;
import com.systemcontroller.domain.shared.GenericObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SystemOrderService {

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ISystemOrderServiceFeignClient orderServiceFeignClient;

    public ResponseEntity<?> bringAll(Integer page, Integer pageSize){
        return  this.orderServiceFeignClient.findAll(page,pageSize);
    }

    public ResponseEntity<?> bringByid(Integer id){
        return  this.orderServiceFeignClient.findById(id);
    }

    public ResponseEntity<?> saveObject(OrderServiceDto orderServiceDto){
        OrderServiceDto orderService = this.mapper.mapTo(orderServiceDto, OrderServiceDto.class);
        return this.orderServiceFeignClient.save(orderService);
    }

    public ResponseEntity<?> updateObject(OrderServiceDto orderServiceDto){
        OrderServiceDto orderService = this.mapper.mapTo(orderServiceDto, OrderServiceDto.class);
        return this.orderServiceFeignClient.update(orderService);
    }

    public void deleteObject(Integer id){
        this.orderServiceFeignClient.delete(id);
    }
}
