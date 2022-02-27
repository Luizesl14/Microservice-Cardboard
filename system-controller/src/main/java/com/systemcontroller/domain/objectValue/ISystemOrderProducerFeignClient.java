package com.systemcontroller.domain.objectValue;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "system-order-producer", url ="localhost:8081", path = "/order-producer")
public interface ISystemOrderProducerFeignClient {

    @GetMapping(value = "/all")
    Page<Object> findAll(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize);

    @GetMapping(value = "/{id}")
    Object findById(@PathVariable Integer id);

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Object save(@RequestBody Object obj);

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Object update(@RequestBody Object obj);

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<?> delete(@RequestParam Integer id);

}
