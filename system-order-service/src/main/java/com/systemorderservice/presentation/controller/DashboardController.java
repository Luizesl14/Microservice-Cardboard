package com.systemorderservice.presentation.controller;


import com.systemorderservice.aplicatiton.core.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController{

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value = "/all-quantity")
    public ResponseEntity<Integer> findAllQuantity(){
      return  ResponseEntity.status(HttpStatus.OK).body(
              this.dashboardService.quantityService());
    }

    @GetMapping(value = "/all-pending")
    public ResponseEntity<Integer> findAllPending(){
        return  ResponseEntity.status(HttpStatus.OK).body(
                this.dashboardService.quantityPending());
    }

    @GetMapping(value = "/all-lost")
    public ResponseEntity<Integer> findAllLost(){
        return  ResponseEntity.status(HttpStatus.OK).body(
                this.dashboardService.quantityLost());
    }

    @GetMapping(value = "/all-closed")
    public ResponseEntity<Integer> findAllClosed(){
        return  ResponseEntity.status(HttpStatus.OK).body(
                this.dashboardService.quantityClosed());
    }

}
