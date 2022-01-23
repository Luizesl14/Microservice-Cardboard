package com.systemorderservice.insfrastructure.resource;


import com.systemorderservice.aplicatiton.dto.StatusOsTypeDto;
import com.systemorderservice.insfrastructure.service.StatusOsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/status-os")
@RequiredArgsConstructor(onConstructor = @___(@Autowired))
@AllArgsConstructor
public class StatusOsResource {

    private StatusOsService statusOsService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<StatusOsTypeDto>> findAll(){
       List<StatusOsTypeDto> response = this.statusOsService.findAllStatus();
      if(response.isEmpty()){
         return  ResponseEntity.notFound().build();
      }
      return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<StatusOsTypeDto> findByid(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.statusOsService.findIdStatus(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusOsTypeDto> save(@RequestBody StatusOsTypeDto statusOsTypeDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.statusOsService.saveStatus(statusOsTypeDto));
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusOsTypeDto> uodate(@RequestBody StatusOsTypeDto statusOsTypeDto){
        return ResponseEntity.status(HttpStatus.OK).body(this.statusOsService.updateStatus(statusOsTypeDto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id){
        this.statusOsService.deleteStatus(id);
        return  ResponseEntity.ok().build();
    }
}
