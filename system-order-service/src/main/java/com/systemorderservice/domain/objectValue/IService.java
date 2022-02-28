package com.systemorderservice.domain.objectValue;

import com.systemorderservice.aplicatiton.dto.OrderServiceDto;
import org.springframework.data.domain.Page;

public interface IService<T> {
    Page<T> bringAll(Integer page, Integer pageSize);
    T bringByid(Integer id);
    T saveObject(T t);
    OrderServiceDto updateObject(OrderServiceDto t);
    void deleteObject(Integer id);
    T creatObject(T t);
}
