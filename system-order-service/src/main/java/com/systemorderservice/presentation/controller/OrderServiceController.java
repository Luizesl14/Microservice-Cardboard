package com.systemorderservice.presentation.controller;


import com.systemorderservice.aplicatiton.dto.OrderServiceDto;
import com.systemorderservice.domain.objectValue.IController;
import com.systemorderservice.insfrastructure.service.SOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order-service")
public class OrderServiceController implements IController {

    @Autowired
    private SOrderService ServiceOrderService;

    @GetMapping(value = "/all")
    public ResponseEntity<Page<OrderServiceDto>> findAll(Integer page, Integer pageSize){
      return  ResponseEntity.status(HttpStatus.OK).body(
              this.ServiceOrderService.bringAll(page, pageSize));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderServiceDto> findById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.ServiceOrderService.bringByid(id));
    }


    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderServiceDto> saveObject(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.ServiceOrderService.saveObject(obj));
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderServiceDto> updateObject(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.ServiceOrderService.updateObject(obj));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteObject(@RequestParam Long id){
        this.ServiceOrderService.deleteObject(id);
        return  ResponseEntity.ok().build();
    }
}
