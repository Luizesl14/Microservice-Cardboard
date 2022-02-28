package com.systemcontroller.domain.objectValue;

import com.systemcontroller.aplicatiton.dto.OrderProducerDto;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "system-order-producer", url ="localhost:8083", path = "/order-producer")
public interface ISystemOrderProducerFeignClient {

    @CollectionFormat(feign.CollectionFormat.CSV)
    @GetMapping
    ResponseEntity<?> findAll(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize);

    @GetMapping(value = "/{id}")
    ResponseEntity<?> findById(@PathVariable Integer id);

    @PostMapping
    ResponseEntity<?> save(@RequestBody OrderProducerDto obj);

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> update(@RequestBody OrderProducerDto obj);

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id);

}
