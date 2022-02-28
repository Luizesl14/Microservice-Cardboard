package com.systemorderservice.domain.objectValue.valueExtends;

import com.systemorderservice.aplicatiton.dto.OrderStatusDto;
import org.springframework.http.ResponseEntity;


public interface IControllerStatus<T> {
    ResponseEntity<T> findAll(Integer page, Integer pageSize);
    ResponseEntity<T> findById(Integer id);
    ResponseEntity<T> saveObject(T t);
    ResponseEntity<OrderStatusDto> updateObject(OrderStatusDto t);
    ResponseEntity<T> deleteObject(Integer id);
}
