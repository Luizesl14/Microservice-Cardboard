package com.systemcontroller.presentation.controller;

import com.systemcontroller.aplicatiton.core.service.OrderService;
import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.objectValue.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/order")
public class OrderController implements IController {

    @Autowired
    private OrderService orderService;

    @RolesAllowed("admin")
    @GetMapping(value = "/all")
    public ResponseEntity<Page<OrderDto>> findAll(Integer page, Integer pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderService.bringAll(page, pageSize));
    }


    @RolesAllowed("admin")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderService.bringByid(id));
    }


    @RolesAllowed("admin")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> save(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.orderService.saveObject(obj));
    }

    @RolesAllowed("admin")
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> update(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.orderService.updateObject(obj));
    }

    @RolesAllowed({"user", "admin"})
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        this.orderService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
