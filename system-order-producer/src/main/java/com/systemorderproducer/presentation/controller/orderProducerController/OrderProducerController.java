package com.systemorderproducer.presentation.controller.orderProducerController;


import com.systemorderproducer.aplicatiton.dto.OrderProducerDto;
import com.systemorderproducer.domain.services.icontroller.IOrderProducerController;
import com.systemorderproducer.insfrastructure.service.OrderProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/op")
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

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<OrderProducerDto> findById(@RequestParam Long opId){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderProducerService.bringByid(opId));
    }

    @PostMapping(value = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderProducerDto> save(@RequestBody OrderProducerDto orderProducerDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderProducerService.saveEntity(orderProducerDto));
    }

    @PutMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderProducerDto> update(@RequestBody OrderProducerDto OrderProducerDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.orderProducerService.updateEntity(OrderProducerDto));
    }

    public ResponseEntity delete(Long id) {
        this.orderProducerService.deleteEntity(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
