package com.systemorderservice.insfrastructure.resource;


import com.orderService.aplicatiton.dto.OsOsDto;
import com.systemorderservice.insfrastructure.service.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/os")
public class OsResource {

    @Autowired
    private OsService osService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<OsOsDto>> findAll(){
       List<OsOsDto> response = this.osService.findAllOp();
      if(response.isEmpty()){
         return  ResponseEntity.notFound().build();
      }
      return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OsOsDto> findByid(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.osService.findIdOp(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OsOsDto> save(@RequestBody OsOsDto osDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.osService.saveOp(osDto));
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OsOsDto> uodate(@RequestBody OsOsDto osDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.osService.updateOP(osDto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id){
        this.osService.deleteOp(id);
        return  ResponseEntity.ok().build();
    }
}
