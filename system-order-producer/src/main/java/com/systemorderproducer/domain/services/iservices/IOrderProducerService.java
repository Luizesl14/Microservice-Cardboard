package com.systemorderproducer.domain.services.iservices;

import com.systemorderproducer.aplicatiton.dto.OrderProducerDto;
import org.springframework.data.domain.Page;

public interface IOrderProducerService {
    Page<?> bringAll(Integer page, Integer pageSize);
    OrderProducerDto bringByid(Long id);
    OrderProducerDto saveEntity(OrderProducerDto orderProducerDto);
    OrderProducerDto updateEntity(OrderProducerDto orderProducerDto);
    void deleteEntity(Long id);
}
