package com.systemorderservice.domain.objectValue.valueExtends;

import com.systemorderservice.aplicatiton.dto.OrderStatusDto;
import org.springframework.data.domain.Page;

public interface IOrderStatusService<T>{
    Page<T> bringAll(Integer page, Integer pageSize);
    T bringByid(Integer id);
    T saveObject(T t);
    OrderStatusDto updateObject(OrderStatusDto t);
    void deleteObject(Integer id);

}
