package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.model.Order;
import com.systemcontroller.domain.objectValue.IControllerService;
import com.systemcontroller.domain.objectValue.ISystemOrderServiceFeignClient;
import com.systemcontroller.insfrastructure.http.OrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public class DeashBoardService{

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ISystemOrderServiceFeignClient orderServiceFeignClient;

    public Integer quantityOrderService(){
        return null;
    }

    public Integer quantityOrderProducer(){
        return null;
    }

    public Integer quantityWorker(){
        return null;
    }

    public Integer quantityPending(){
        return null;
    }

    public Integer quantityLost(){
        return null;
    }

    public Integer quantityDevelopment(){
        return null;
    }

}
