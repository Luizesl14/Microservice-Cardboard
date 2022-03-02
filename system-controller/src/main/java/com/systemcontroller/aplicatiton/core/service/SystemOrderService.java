package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.aplicatiton.dto.OrderServiceDto;
import com.systemcontroller.domain.model.Order;
import com.systemcontroller.domain.objectValue.ISystemOrderServiceFeignClient;
import com.systemcontroller.domain.shared.GenericObjectMapper;
import com.systemcontroller.insfrastructure.http.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemOrderService {

    private static final String NOT_ORDER = "Order serviçe so pode ser criada após pagamento [Order aguardanto confimação de pagamento!]";

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ISystemOrderServiceFeignClient orderServiceFeignClient;

    @Autowired
    private OrderService orderService;

    public ResponseEntity<?> bringAll(Integer page, Integer pageSize){
        return  this.orderServiceFeignClient.findAll(page,pageSize);
    }

    public ResponseEntity<?> bringByid(Integer id){
        return  this.orderServiceFeignClient.findById(id);
    }

    @Transactional
    public OrderServiceDto saveObject(Integer orderId, OrderServiceDto obj){
        OrderDto orderDto = this.orderService.bringByid(orderId);
        OrderServiceDto orderServiceDto ;
        OrderServiceDto orderService = this.mapper.mapTo(obj, OrderServiceDto.class);
           if(orderDto.getIsActive() == Boolean.TRUE && orderDto.getPayment().getApprovedPayment() == Boolean.TRUE){
               orderServiceDto = this.orderServiceFeignClient.save(orderService).getBody();
        }else{
               throw new OrderException(NOT_ORDER, HttpStatus.PAYMENT_REQUIRED);
           }
        orderDto.setOrderServiceId(orderServiceDto.getId());
        this.orderService.updateObject(orderDto);
        return orderServiceDto;
    }

    @Transactional
    public OrderServiceDto updateObject(Integer orderId, OrderServiceDto obj){
        OrderDto orderDto = this.orderService.bringByid(orderId);
        OrderServiceDto orderServiceDto ;
        OrderServiceDto orderService = this.mapper.mapTo(obj, OrderServiceDto.class);
        if(orderDto.getIsActive() == Boolean.TRUE && orderDto.getPayment().getApprovedPayment() == Boolean.TRUE){
            orderServiceDto = this.orderServiceFeignClient.update(orderService).getBody();
        }else{
            throw new OrderException(NOT_ORDER, HttpStatus.PAYMENT_REQUIRED);
        }
        orderDto.setOrderServiceId(orderServiceDto.getId());
        this.orderService.updateObject(orderDto);
        return orderServiceDto;
    }

    public void deleteObject(Integer id){
        this.orderServiceFeignClient.delete(id);
    }
}
