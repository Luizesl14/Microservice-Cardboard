package com.systemorderproducer.insfrastructure.service;

import com.orderService.aplicatiton.dto.OpOsDto;
import com.systemorderproducer.domain.entity.Op;
import com.systemorderproducer.domain.repository.OpRepository;
import model.GenericEntity_;
import model.GenericObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OPService {

    private final GenericObjectMapper mapper = new GenericObjectMapper();
    @Autowired
    private OpRepository opRepository;


    public List<OpOsDto> findAllOp(){
        return this.mapper.mapListTo(this.opRepository.findAll(), OpOsDto.class);
    }

    public OpOsDto findIdOp(Long opId){
        Op op = this.opRepository.findById(opId).orElseThrow(()-> new RuntimeException(("ORDEM DE SERVICO - NOT FOUND")));
        return  this.mapper.mapTo(op.getId(), OpOsDto.class);
    }

    public OpOsDto saveOp(OpOsDto opDto){
        this.opRepository.save(this.mapper.mapTo(opDto, Op.class));
        return  this.findIdOp(opDto.getId());
    }

    public OpOsDto updateOP(OpOsDto opDto){
       Op newOp =  this.opRepository.save(this.mapper.mapTo(opDto, Op.class));
       Op serarchOP = this.opRepository.findById(opDto.getId()).orElseThrow(
               ()-> new RuntimeException("RDEM DE SERVICO - NOT FOUND")
       );
        BeanUtils.copyProperties(newOp, serarchOP, GenericEntity_.ID,GenericEntity_.IDENTIFY,
               GenericEntity_.CREATED_AT,GenericEntity_.DELIVERY_DATE);
        return this.mapper.mapTo(this.opRepository.save(newOp), OpOsDto.class) ;

    }

    public void deleteOp(Long opId){
        this.opRepository.deleteById(opId);
    }


}
