package com.systemorderservice.aplicatiton.core.service;

import com.systemorderservice.aplicatiton.core.configuration.GenericEntity_;
import com.systemorderservice.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemorderservice.aplicatiton.core.configuration.IServiceFeignClient;
import com.systemorderservice.aplicatiton.dto.OrderServiceDto;
import com.systemorderservice.domain.model.BoxBody;
import com.systemorderservice.domain.model.OrderService;
import com.systemorderservice.domain.objectValue.IService;
import com.systemorderservice.insfrastructure.repository.IOrderServiceRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@EnableScheduling
@Service
public class SOrderService implements IService {

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    @Autowired
    private  GenericObjectMapper mapper;

    @Autowired
    private IOrderServiceRepository IOrderServiceRepository;

    @Autowired
    private IServiceFeignClient serviceFeignClient;

    public Page<OrderServiceDto> bringAll(Integer page, Integer pageSize){
        return this.mapper.mapEntityPageIntoDtoPage(
                this.IOrderServiceRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id"))), OrderServiceDto.class);
    }

    public OrderServiceDto bringByid(Integer id){
        OrderService orderService = this.IOrderServiceRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, "ORDEM DE SERVICO - NOT FOUND"));
        return  this.mapper.mapTo(orderService, OrderServiceDto.class);
    }

    public OrderServiceDto saveObject(Object obj){
        OrderService orderService =  this.creatObject(obj);
        this.IOrderServiceRepository.save(orderService);
        return  this.bringByid(orderService.getId());
    }

    public OrderServiceDto updateObject(Object obj){
        OrderServiceDto orderServiceDto =  this.mapper.mapTo(obj, OrderServiceDto.class);
       OrderService newOrderService =  this.IOrderServiceRepository.save(
               this.mapper.mapTo(orderServiceDto, OrderService.class));

       OrderService serarchOrderService = this.IOrderServiceRepository.findById(orderServiceDto.getId())
               .orElseThrow(()-> new ObjectNotFoundException(orderServiceDto.getId(), "ORDEM DE SERVICO - NOT FOUND"));

        BeanUtils.copyProperties(newOrderService, serarchOrderService, GenericEntity_.ID, GenericEntity_.IDENTIFY,
              GenericEntity_.CREATED_AT, GenericEntity_.DELIVERY_DATE);

        return this.mapper.mapTo(
                this.IOrderServiceRepository.save(newOrderService), OrderServiceDto.class);

    }

    public void deleteObject(Integer id){
        this.IOrderServiceRepository.deleteById(id);
    }



    public boolean postObject(Object obj) {
        OrderServiceDto orderServiceDto =  this.mapper.mapTo(obj, OrderServiceDto.class);
        if (orderServiceDto.isShippingForProduction()){
            this.serviceFeignClient.sendObject(orderServiceDto);
            return true;
        }
       return false;
    }


    //@Scheduled(fixedRate = 3 * HORA)
    public void observableTrue(){
        List<OrderService> shippingTrue = this.IOrderServiceRepository.findOrderServiceBy();
        for (OrderService od : shippingTrue){
            this.postObject(od);
        }
    }


    public OrderService creatObject(Object obj) {
        OrderService orderService = this.mapper.mapTo(obj, OrderService.class);
        orderService.setCreatedAt(LocalDateTime.now());
        orderService.setDeliveryDate(LocalDateTime.now().plusDays(10));
        BoxBody boxBody = new BoxBody();

        boxBody.setLength(orderService.getBoxBody().getLength());
        boxBody.setWidth(orderService.getBoxBody().getWidth());
        boxBody.setHeight(orderService.getBoxBody().getHeight());
        boxBody.setValueLengthCalc(orderService.getBoxBody().getValueLengthCalc());
        boxBody.setValueWidthCalc(orderService.getBoxBody().getValueWidthCalc());
        boxBody.setValueHeightCalc(orderService.getBoxBody().getValueHeightCalc());

        boxBody.setDilatedLengthOne(boxBody.getValueLengthCalc() + boxBody.getLength());
        boxBody.setDilatedWidthOne(boxBody.getValueWidthCalc() + boxBody.getWidth());
        boxBody.setDilatedLengthTwo(boxBody.getValueLengthCalc() + boxBody.getLength());
        boxBody.setDilatedWidthTwo(boxBody.getValueWidthCalc() - boxBody.getWidth());
        boxBody.setDilatedHeight(boxBody.getValueHeightCalc() + boxBody.getHeight());
        boxBody.setDiletedAbasSup(boxBody.getValueAbaSup() != null ? orderService.getBoxBody().getValueAbaSup()
                : Math.floorDiv(boxBody.getDilatedWidthOne(), 2) );
        boxBody.setDiletedAbasSub(boxBody.getValueAbaSup() != null ? boxBody.getValueAbaSup()
                : Math.floorDiv(boxBody.getDilatedWidthOne(), 2));
        orderService.setBoxBody(boxBody);
        return orderService;
    }

}
