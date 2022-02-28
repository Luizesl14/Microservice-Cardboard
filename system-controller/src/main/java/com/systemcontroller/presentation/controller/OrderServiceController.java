package com.systemcontroller.presentation.controller;

import com.systemcontroller.aplicatiton.core.service.SystemOrderService;
import com.systemcontroller.aplicatiton.dto.OrderServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/controller-order-service")
public class OrderServiceController {

    @Autowired
    private SystemOrderService systemOrderService;


    @RolesAllowed("admin")
    @GetMapping(value = "/all")
    public ResponseEntity<?> findAll(Integer page, Integer pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(this.systemOrderService.bringAll(page, pageSize));
    }

    @RolesAllowed({"user", "admin"})
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.systemOrderService.bringByid(id));
    }


    @RolesAllowed({"user", "admin"})
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody OrderServiceDto orderServiceDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.systemOrderService.saveObject(orderServiceDto));
    }

    @RolesAllowed({"user", "admin"})
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody OrderServiceDto orderServiceDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.systemOrderService.updateObject(orderServiceDto));
    }

    @RolesAllowed({"user", "admin"})
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        this.systemOrderService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
