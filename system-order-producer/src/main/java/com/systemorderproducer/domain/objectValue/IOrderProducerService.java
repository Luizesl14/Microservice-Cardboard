package com.systemorderproducer.domain.objectValue;

import com.systemorderproducer.aplicatiton.dto.OrderProducerDto;
import org.springframework.data.domain.Page;

public interface IOrderProducerService<T> {
    Page<?> bringAll(Integer page, Integer pageSize);
    T bringByid(Integer id);
    boolean saveObject(String order);
    OrderProducerDto updateObject(OrderProducerDto orderProducerDto);
    void deleteObject(Integer id);
    T creatObject(T t);
}
