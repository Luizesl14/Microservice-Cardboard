package com.systemcontroller.presentation.controller;

import com.systemcontroller.aplicatiton.core.service.CompanyService;
import com.systemcontroller.aplicatiton.dto.CompanyDto;
import com.systemcontroller.domain.objectValue.IController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/company")
public class CompanyController implements IController {

    @Autowired
    private CompanyService companyService;

    @RolesAllowed({"user", "admin"})
    @GetMapping(value = "/all")
    public ResponseEntity<Page<CompanyDto>> findAll(Integer page, Integer pageSize){
        return ResponseEntity.status(HttpStatus.OK).body(this.companyService.bringAll(page, pageSize));
    }

    @RolesAllowed({"user", "admin"})
    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDto> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(this.companyService.bringByid(id));
    }


    @RolesAllowed({"user", "admin"})
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDto> save(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.companyService.saveObject(obj));
    }

    @RolesAllowed({"user", "admin"})
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDto> update(@RequestBody Object obj){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.companyService.updateObject(obj));
    }

    @RolesAllowed({"user", "admin"})
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        this.companyService.deleteObject(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Object> createOrderService(Integer id, Object obj) {
        return null;
    }
}
