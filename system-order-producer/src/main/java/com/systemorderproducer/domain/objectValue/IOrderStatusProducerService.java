package com.systemorderproducer.domain.objectValue;

import org.springframework.data.domain.Page;

public interface IOrderStatusProducerService<T> {
    Page<?> bringAll(Integer page, Integer pageSize);
    T bringByid(Integer id);
    T saveObject(T t);
    T updateObject(T t);
    void deleteObject(Integer id);
    T creatObject(T t);
}
