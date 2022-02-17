package com.systemorderservice.aplicatiton.core.service;

import com.systemorderservice.aplicatiton.dto.OrderServiceDto;
import com.systemorderservice.domain.model.OrderService;
import com.systemorderservice.insfrastructure.http.OrderServiceException;
import com.systemorderservice.insfrastructure.repository.IOrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class DashboardService{

    @Autowired
    private IOrderServiceRepository orderServiceRepository;


    public Integer quantityService(){
        return  this.orderServiceRepository.findAllQuantityService();
    }

    public Integer quantityClosed(){
        return  this.orderServiceRepository.findAllQuantityClosed();
    }
    public Integer quantityPending(){
        return  this.orderServiceRepository.findAllQuantityPending();
    }

    public Integer quantityLost(){
        return  this.orderServiceRepository.findAllQuantityLost();
    }


}
