package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.domain.shared.GenericEntity_;
import com.systemcontroller.domain.shared.GenericObjectMapper;
import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.model.Order;
import com.systemcontroller.domain.objectValue.IOrderService;
import com.systemcontroller.insfrastructure.http.OrderException;
import com.systemcontroller.insfrastructure.repositories.IOrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    private final String NO_FOUND_MSG = "Order não encontrada na base de dados";
    private final String ERROR_SERVER = "Houve um erro no servidor tente novamente mais tarde";

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private SystemOrderService orderService;


    public Page<OrderDto> bringAll(Integer page, Integer pageSize){
            return this.mapper.mapEntityPageIntoDtoPage(
                    this.orderRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id"))), OrderDto.class);
    }

    public OrderDto bringByid(Integer id){
        Order order = this.orderRepository.findById(id)
                .orElseThrow(()-> new OrderException(NO_FOUND_MSG, HttpStatus.NOT_FOUND));
        return  this.mapper.mapTo(order, OrderDto.class);
    }

    public OrderDto saveObject(Object obj){
        Order order = this.mapper.mapTo(obj, Order.class);
        this.orderRepository.save(order);
        return this.bringByid(order.getId());
    }

    public OrderDto updateObject(Object obj){
        OrderDto orderDto =  this.mapper.mapTo(obj, OrderDto.class);
        Order newOrder =  this.orderRepository.save(
                this.mapper.mapTo(orderDto, Order.class));

        Order serarchOrderService = this.orderRepository.findById(orderDto.getId())
                .orElseThrow(()-> new OrderException(NO_FOUND_MSG, HttpStatus.NOT_FOUND));

        BeanUtils.copyProperties(newOrder, serarchOrderService, GenericEntity_.ID, GenericEntity_.IDENTIFY,
                GenericEntity_.CREATED_AT, GenericEntity_.DELIVERY_DATE);

        return this.mapper.mapTo(
                this.orderRepository.save(newOrder), OrderDto.class);
    }

    public void deleteObject(Integer id){
        this.orderRepository.deleteById(id);
    }

    public OrderDto creatOrderService(Integer id, Object obj) {
        OrderDto orderDto = this.bringByid(id);

        if(orderDto.getIsActive().equals(Boolean.TRUE)
                && orderDto.getPayment().getApprovedPayment().equals(Boolean.TRUE) ){
            this.orderService.saveObject(obj);
        }else {
           throw new OrderException("Pagamento em análise aguarde!", HttpStatus.BAD_REQUEST);
        }
        return orderDto;
    }

}
