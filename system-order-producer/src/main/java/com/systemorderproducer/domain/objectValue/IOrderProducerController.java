package com.systemorderproducer.domain.objectValue;

import com.systemorderproducer.aplicatiton.dto.OrderProducerDto;
import org.springframework.http.ResponseEntity;


public interface IOrderProducerController<T> {
    ResponseEntity<T> findAll(Integer page, Integer pageSize);
    ResponseEntity<T> findById(Integer id);
    ResponseEntity<T> save(String obj);
    ResponseEntity<OrderProducerDto> update(OrderProducerDto OrderProducerDto);
    ResponseEntity<T> delete(Integer id);
}
