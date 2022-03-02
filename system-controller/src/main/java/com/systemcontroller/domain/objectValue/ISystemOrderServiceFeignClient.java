package com.systemcontroller.domain.objectValue;

import com.systemcontroller.aplicatiton.dto.OrderServiceDto;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "system-order-service", url = "localhost:8082", path = "/order-service")
public interface ISystemOrderServiceFeignClient{

    @CollectionFormat(feign.CollectionFormat.CSV)
    @GetMapping(value = "/all")
    ResponseEntity<?> findAll(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Integer id);

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderServiceDto> save(@RequestBody Object obj);

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OrderServiceDto> update(@RequestBody Object obj);

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);


}
