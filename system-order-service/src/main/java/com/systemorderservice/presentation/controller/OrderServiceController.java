package com.systemorderservice.presentation.controller;


import com.systemorderservice.aplicatiton.core.service.SOrderService;
import com.systemorderservice.aplicatiton.dto.OrderServiceDto;
import com.systemorderservice.domain.objectValue.IOrderServiceController;
import com.systemorderservice.insfrastructure.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order-service")
public class OrderServiceController implements IOrderServiceController {

    private static final String BUSCAR_TODOS ="BUSCAR TODOS";
    private static final String BUSCAR_POR_ID ="BUSCAR POR ID";
    private static final String SAVE ="SALVAR";
    private static final String UPDATE ="UPDATE";
    private static final String DELETE ="DELETE";

    @Autowired
    private SOrderService ServiceOrderService;

    @GetMapping(value = "/all")
    public ResponseEntity<Page<OrderServiceDto>> findAll(Integer page, Integer pageSize){
      return  ResponseEntity.status(HttpStatus.OK).body(
              this.ServiceOrderService.bringAll(page, pageSize));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderServiceDto> findById(@PathVariable Integer id){
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
    public ResponseEntity<?> deleteObject(@RequestParam Integer id){
        this.ServiceOrderService.deleteObject(id);
        return  ResponseEntity.ok().build();
    }
}
