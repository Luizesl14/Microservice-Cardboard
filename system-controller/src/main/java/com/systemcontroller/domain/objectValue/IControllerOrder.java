package com.systemcontroller.domain.objectValue;

import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.model.Order;
import org.springframework.http.ResponseEntity;


public interface IControllerOrder<T> {
    ResponseEntity<T> findAll(Integer page, Integer pageSize);
    ResponseEntity<T> findById(Integer id);
    ResponseEntity<T> save(OrderDto t);
    ResponseEntity<T> update(OrderDto t);
    ResponseEntity<T> delete(Integer id);
}
