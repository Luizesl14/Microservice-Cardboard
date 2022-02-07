package com.systemorderservice.aplicatiton.core.configuration;

import com.systemorderservice.aplicatiton.dto.OrderServiceDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "system-order-producer", path = "/order-producer")
@RibbonClient(name ="system-order-producer")
public interface IServiceFeignClient {

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<OrderServiceDto> sendObject(OrderServiceDto orderServiceDto);
}
