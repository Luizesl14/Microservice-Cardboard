package com.systemcontroller.domain.objectValue;

import com.systemcontroller.aplicatiton.dto.OrderDto;
import org.springframework.data.domain.Page;

public interface IServiceOrder<T> {
    Page<?> bringAll(Integer page, Integer pageSize);
    T bringByid(Integer id);
    T saveObject(OrderDto t);
    T updateObject(OrderDto t);
    void deleteObject(Integer id);
}
