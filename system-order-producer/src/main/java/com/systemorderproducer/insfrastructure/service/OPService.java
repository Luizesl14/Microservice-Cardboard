package com.systemorderproducer.insfrastructure.service;

import com.systemorderproducer.aplicatiton.configuration.GenericEntity_;
import com.systemorderproducer.aplicatiton.configuration.GenericObjectMapper;
import com.systemorderproducer.aplicatiton.dto.OpDto;
import com.systemorderproducer.domain.entity.Op;
import com.systemorderproducer.domain.repository.OpRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OPService {

    private final GenericObjectMapper mapper = new GenericObjectMapper();
    @Autowired
    private OpRepository opRepository;


    public List<OpDto> findAllOp(){
        return this.mapper.mapListTo(this.opRepository.findAll(), OpDto.class);
    }

    public OpDto findIdOp(Long opId){
        Op op = this.opRepository.findById(opId).orElseThrow(()-> new RuntimeException(("ORDEM DE SERVICO - NOT FOUND")));
        return  this.mapper.mapTo(op.getId(), OpDto.class);
    }

    public OpDto saveOp(OpDto opDto){
        this.opRepository.save(this.mapper.mapTo(opDto, Op.class));
        return  this.findIdOp(opDto.getId());
    }

    public OpDto updateOP(OpDto opDto){
       Op newOp =  this.opRepository.save(this.mapper.mapTo(opDto, Op.class));
       Op serarchOP = this.opRepository.findById(opDto.getId()).orElseThrow(
               ()-> new RuntimeException("RDEM DE SERVICO - NOT FOUND")
       );
        BeanUtils.copyProperties(newOp, serarchOP, GenericEntity_.ID,GenericEntity_.IDENTIFY,
               GenericEntity_.CREATED_AT,GenericEntity_.DELIVERY_DATE);
        return this.mapper.mapTo(this.opRepository.save(newOp), OpDto.class) ;

    }

    public void deleteOp(Long opId){
        this.opRepository.deleteById(opId);
    }


}
