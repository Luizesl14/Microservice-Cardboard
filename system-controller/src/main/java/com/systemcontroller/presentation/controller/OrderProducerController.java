package com.systemcontroller.presentation.controller;

import com.systemcontroller.aplicatiton.core.service.SystemOrderProducerService;
import com.systemcontroller.aplicatiton.dto.OrderProducerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/controller-corder-producer")
public class OrderProducerController{

    @Autowired
    private SystemOrderProducerService systemOrderProducerService;

    @RolesAllowed("admin")
    @GetMapping(value = "/all")
    public ResponseEntity<?> findAll(Integer page, Integer pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(this.systemOrderProducerService.bringAll(page, pageSize));
    }

    @RolesAllowed({"user", "admin"})
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.systemOrderProducerService.bringByid(id));
    }


    @RolesAllowed("admin")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody OrderProducerDto OrderProducerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.systemOrderProducerService.saveObject(OrderProducerDto));
    }

    @RolesAllowed({"user", "admin"})
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>update(@RequestBody OrderProducerDto OrderProducerDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.systemOrderProducerService.updateObject(OrderProducerDto));
    }

    @RolesAllowed({"user", "admin"})
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        this.systemOrderProducerService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
