package com.systemcontroller.presentation.controller;

import com.systemcontroller.aplicatiton.core.service.OrderService;
import com.systemcontroller.aplicatiton.core.service.SystemOrderService;
import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.objectValue.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller-corder-service")
public class OrderServiceController implements IController {

    @Autowired
    private SystemOrderService systemOrderService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/all")
    public ResponseEntity<Page<OrderDto>> findAll(Integer page, Integer pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(this.systemOrderService.bringAll(page, pageSize));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.systemOrderService.bringByid(id));
    }


    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> save(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.systemOrderService.saveObject(obj));
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> update(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.systemOrderService.updateObject(obj));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        this.systemOrderService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Object> createOrderService(Integer id, Object obj) {
        return null;
    }
}
