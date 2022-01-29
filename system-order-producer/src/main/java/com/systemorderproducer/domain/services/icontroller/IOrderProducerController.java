package com.systemorderproducer.domain.services.icontroller;

import com.systemorderproducer.aplicatiton.dto.OrderProducerDto;
import org.springframework.http.ResponseEntity;


public interface IOrderProducerController {
    ResponseEntity<?> findAll(Integer page, Integer pageSize);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> save(OrderProducerDto orderProducerDto);
    ResponseEntity<?> update(OrderProducerDto orderProducerDto);
    ResponseEntity<?> delete(Long id);
}
