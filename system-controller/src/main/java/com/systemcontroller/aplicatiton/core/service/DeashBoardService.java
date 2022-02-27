package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.domain.shared.GenericObjectMapper;
import com.systemcontroller.domain.objectValue.ISystemOrderServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
