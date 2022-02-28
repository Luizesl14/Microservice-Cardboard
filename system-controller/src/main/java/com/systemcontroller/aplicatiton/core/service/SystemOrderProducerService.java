package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.dto.OrderProducerDto;
import com.systemcontroller.domain.objectValue.ISystemOrderProducerFeignClient;
import com.systemcontroller.domain.shared.GenericObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SystemOrderProducerService {

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ISystemOrderProducerFeignClient orderProducerFeignClient;


    public ResponseEntity<?> bringAll(Integer page, Integer pageSize){
            return  this.orderProducerFeignClient.findAll(page,pageSize);
    }

    public ResponseEntity<?> bringByid(Integer id){
        return  this.orderProducerFeignClient.findById(id);
    }

    public ResponseEntity<?> saveObject(OrderProducerDto orderProducerDto){
        OrderProducerDto orderProducer = this.mapper.mapTo(orderProducerDto, OrderProducerDto.class);
        return this.orderProducerFeignClient.save(orderProducer);
    }

    public ResponseEntity<?> updateObject(OrderProducerDto orderProducerDto){
        OrderProducerDto orderProducer = this.mapper.mapTo(orderProducerDto, OrderProducerDto.class);
        return this.orderProducerFeignClient.update(orderProducer);
    }

    public void deleteObject(Integer id){
        this.orderProducerFeignClient.delete(id);
    }


}
