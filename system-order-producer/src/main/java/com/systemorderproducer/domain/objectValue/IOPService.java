package com.systemorderproducer.domain.objectValue;

import org.springframework.data.domain.Page;

public interface IOPService<T> {
    Page<?> bringAll(Integer page, Integer pageSize);
    T bringByid(Long id);
    T saveObject(T t);
    T updateObject(T t);
    void deleteObject(Long id);
    T creatObject(T t);
}
