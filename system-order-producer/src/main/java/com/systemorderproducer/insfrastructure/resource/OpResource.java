package com.systemorderproducer.insfrastructure.resource;


import com.systemorderproducer.aplicatiton.dto.OpDto;
import com.systemorderproducer.insfrastructure.service.OPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/op")
public class OpResource {

    @Autowired
    private OPService opService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<OpDto>> findAll(){
       List<OpDto> response = this.opService.findAllOp();
      if(response.isEmpty()){
         return  ResponseEntity.notFound().build();
      }
      return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<OpDto> findByid(@RequestParam Long opId){
        return ResponseEntity.status(HttpStatus.OK).body(this.opService.findIdOp(opId));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OpDto> save(@RequestBody OpDto opDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.opService.saveOp(opDto));
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OpDto> uodate(@RequestBody OpDto opDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.opService.updateOP(opDto));
    }

    @DeleteMapping(value = "/delete/id/{id}")
    public ResponseEntity<?> delete(@RequestParam Long opId){
        this.opService.deleteOp(opId);
        return  ResponseEntity.ok().build();
    }
}
