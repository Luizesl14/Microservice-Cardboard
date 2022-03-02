package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.model.Order;
import com.systemcontroller.domain.objectValue.IOrderService;
import com.systemcontroller.domain.objectValue.IServiceOrder;
import com.systemcontroller.domain.shared.GenericEntity_;
import com.systemcontroller.domain.shared.GenericObjectMapper;
import com.systemcontroller.insfrastructure.http.OrderException;
import com.systemcontroller.insfrastructure.repositories.IOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService implements IServiceOrder {

    private final String NO_FOUND_MSG = "Order não encontrada na base de dados";
    private final String ERROR_SERVER = "Houve um erro no servidor tente novamente mais tarde";

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private IOrderRepository orderRepository;


    public Page<OrderDto> bringAll(Integer page, Integer pageSize){
            return this.mapper.mapEntityPageIntoDtoPage(
                    this.orderRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id"))), OrderDto.class);
    }

    public OrderDto bringByid(Integer id){
        Order order = this.orderRepository.findById(id)
                .orElseThrow(()-> new OrderException(NO_FOUND_MSG, HttpStatus.NOT_FOUND));
        return  this.mapper.mapTo(order, OrderDto.class);
    }

    public OrderDto saveObject(OrderDto obj){
        Order order = this.mapper.mapTo(obj, Order.class);
        order.setIdentify(UUID.randomUUID().toString());
        order.setCreatedAt(LocalDateTime.now());
        this.orderRepository.save(order);
        return this.bringByid(order.getId());
    }

    public OrderDto updateObject(OrderDto obj){
        Order newOrder=  this.mapper.mapTo(obj, Order.class);
        Order serarchOrderService = this.mapper.mapTo(this.bringByid(newOrder.getId()), Order.class);

        BeanUtils.copyProperties(newOrder, serarchOrderService, GenericEntity_.ID, GenericEntity_.IDENTIFY,
                GenericEntity_.CREATED_AT);

        return this.mapper.mapTo(
                this.orderRepository.save(newOrder), OrderDto.class);
    }

    public void deleteObject(Integer id){
        this.orderRepository.deleteById(id);
    }

}
