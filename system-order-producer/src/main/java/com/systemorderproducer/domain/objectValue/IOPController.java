package com.systemorderproducer.domain.objectValue;

import org.springframework.http.ResponseEntity;


public interface IOPController<T> {
    ResponseEntity<T> findAll(Integer page, Integer pageSize);
    ResponseEntity<T> findById(Long id);
    ResponseEntity<T> save(T t);
    ResponseEntity<T> update(T t);
    ResponseEntity<T> delete(Long id);
}
