package com.systemorderproducer.presentation.controller;


import com.systemorderproducer.aplicatiton.dto.OrderProducerDto;
import com.systemorderproducer.domain.model.OrderProducer;
import com.systemorderproducer.domain.objectValue.IOrderProducerController;
import com.systemorderproducer.aplicatiton.core.service.OrderProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order-producer")
public class OrderProducerController implements IOrderProducerController {

    @Autowired
    private OrderProducerService orderProducerService;

    @GetMapping
    public ResponseEntity<Page<OrderProducerDto>> findAll(@RequestParam("page") Integer page,
                                                          @RequestParam("pageSize") Integer pageSize){
        if(this.orderProducerService.bringAll(page, pageSize).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(this.orderProducerService.bringAll(page, pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProducerDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderProducerService.bringByid(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody String obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderProducerService.saveObject(obj));
    }

    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderProducerDto> update(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderProducerService.updateObject(obj));
    }

    public ResponseEntity delete(Integer id) {
        this.orderProducerService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
