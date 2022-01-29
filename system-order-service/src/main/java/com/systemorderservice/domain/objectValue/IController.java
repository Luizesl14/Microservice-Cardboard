package com.systemorderservice.domain.objectValue;

import org.springframework.http.ResponseEntity;


public interface IController<T> {
    ResponseEntity<T> findAll(Integer page, Integer pageSize);
    ResponseEntity<T> findById(Long id);
    ResponseEntity<T> saveObject(T t);
    ResponseEntity<T> updateObject(T t);
    ResponseEntity<T> deleteObject(Long id);
}
