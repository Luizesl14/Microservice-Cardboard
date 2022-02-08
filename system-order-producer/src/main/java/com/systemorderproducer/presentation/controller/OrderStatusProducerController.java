package com.systemorderproducer.presentation.controller;


import com.systemorderproducer.aplicatiton.core.service.OrderStatusProducerService;
import com.systemorderproducer.aplicatiton.dto.OrderStatusDto;
import com.systemorderproducer.domain.objectValue.IOrderStatusProducerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order-status")
public class OrderStatusProducerController implements IOrderStatusProducerController{

    @Autowired
    private OrderStatusProducerService orderStatusProducerService;

    @GetMapping
    public ResponseEntity<Page<OrderStatusDto>> findAll(@RequestParam("page") Integer page,
                                                        @RequestParam("pageSize") Integer pageSize){
        if(this.orderStatusProducerService.bringAll(page, pageSize).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(this.orderStatusProducerService.bringAll(page, pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatusDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderStatusProducerService.bringByid(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderStatusDto> save(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderStatusProducerService.saveObject(obj));
    }

    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderStatusDto> update(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderStatusProducerService.updateObject(obj));
    }

    public ResponseEntity delete(Integer id) {
        this.orderStatusProducerService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
