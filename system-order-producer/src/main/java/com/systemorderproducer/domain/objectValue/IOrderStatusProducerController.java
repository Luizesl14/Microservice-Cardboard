package com.systemorderproducer.domain.objectValue;

import org.springframework.http.ResponseEntity;


public interface IOrderStatusProducerController<T> {
    ResponseEntity<T> findAll(Integer page, Integer pageSize);
    ResponseEntity<T> findById(Integer id);
    ResponseEntity<T> save(T t);
    ResponseEntity<T> update(T t);
    ResponseEntity<T> delete(Integer id);
}
