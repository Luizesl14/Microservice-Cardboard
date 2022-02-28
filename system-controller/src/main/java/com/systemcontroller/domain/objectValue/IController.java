package com.systemcontroller.domain.objectValue;

import org.springframework.http.ResponseEntity;


public interface IController<T> {
    ResponseEntity<T> findAll(Integer page, Integer pageSize);
    ResponseEntity<T> findById(Integer id);
    ResponseEntity<T> save(T t);
    ResponseEntity<T> update(T t);
    ResponseEntity<T> delete(Integer id);
}
