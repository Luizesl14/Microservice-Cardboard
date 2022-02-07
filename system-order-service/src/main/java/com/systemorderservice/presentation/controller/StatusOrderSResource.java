package com.systemorderservice.presentation.controller;


import com.systemorderservice.aplicatiton.dto.OrderStatusDto;
import com.systemorderservice.domain.objectValue.IController;
import com.systemorderservice.aplicatiton.core.service.StatusService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/status-os")
@RequiredArgsConstructor(onConstructor = @___(@Autowired))
@AllArgsConstructor
public class StatusOrderSResource implements IController {


    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<Page<OrderStatusDto>> findAll(Integer page, Integer pageSize){

      if(this.statusService.bringAll(page, pageSize).isEmpty()){
         return  ResponseEntity.notFound().build();
      }
      return  ResponseEntity.status(HttpStatus.OK).body(this.statusService.bringAll(page, pageSize));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderStatusDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.statusService.bringByid(id));
    }

    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderStatusDto> saveObject(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.statusService.saveObject(obj));
    }

    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderStatusDto> updateObject(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.OK).body(this.statusService.updateObject(obj));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteObject(@RequestParam Integer id){
        this.statusService.deleteObject(id);
        return  ResponseEntity.ok().build();
    }
}
