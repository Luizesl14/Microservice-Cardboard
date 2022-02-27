package com.systemcontroller.presentation.controller;

import com.systemcontroller.aplicatiton.core.service.PersonService;
import com.systemcontroller.aplicatiton.dto.PersonDto;
import com.systemcontroller.domain.objectValue.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/person")
public class PersonController implements IController {

    @Autowired
    private PersonService personService;

    @RolesAllowed({"user", "admin"})
    @GetMapping(value = "/all")
    public ResponseEntity<Page<PersonDto>> findAll(Integer page, Integer pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(this.personService.bringAll(page, pageSize));
    }

    @RolesAllowed({"user", "admin"})
    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.personService.bringByid(id));
    }


    @RolesAllowed({"user", "admin"})
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> save(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.personService.saveObject(obj));
    }

    @RolesAllowed({"user", "admin"})
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> update(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.personService.updateObject(obj));
    }

    @RolesAllowed({"user", "admin"})
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        this.personService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RolesAllowed({"user", "admin"})
    @Override
    public ResponseEntity<Object> createOrderService(Integer id, Object obj) {
        return null;
    }
}
