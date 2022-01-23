package com.systemorderservice.insfrastructure.service;

import com.orderService.aplicatiton.dto.OsOsDto;
import com.systemorderservice.aplicatiton.configuration.GenericEntity_;
import com.systemorderservice.aplicatiton.configuration.GenericObjectMapper;
import com.systemorderservice.domain.entity.Os;
import com.systemorderservice.domain.repository.OsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OsService {

    private final GenericObjectMapper mapper = new GenericObjectMapper();

    @Autowired
    private OsRepository osRepository;


    public List<OsOsDto> findAllOp(){
        return this.mapper.mapListTo(this.osRepository.findAll(), OsOsDto.class);
    }

    public OsOsDto findIdOp(Long id){
        Os os = this.osRepository.findById(id).orElseThrow(()-> new RuntimeException(("ORDEM DE SERVICO - NOT FOUND")));
        return  this.mapper.mapTo(os, OsOsDto.class);
    }

    public OsOsDto saveOp(OsOsDto osDto){
        this.osRepository.save(this.mapper.mapTo(osDto, Os.class));
        return  this.findIdOp(osDto.getId());
    }

    public OsOsDto updateOP(OsOsDto osDto){
       Os newOs =  this.osRepository.save(this.mapper.mapTo(osDto, Os.class));
       Os serarchOs = this.osRepository.findById(osDto.getId()).orElseThrow(
               ()-> new RuntimeException("RDEM DE SERVICO - NOT FOUND"));
        BeanUtils.copyProperties(newOs, serarchOs, GenericEntity_.ID, GenericEntity_.IDENTIFY,
              GenericEntity_.CREATED_AT, GenericEntity_.DELIVERY_DATE);
        return this.mapper.mapTo(this.osRepository.save(newOs), OsOsDto.class) ;

    }

    public void deleteOp(Long id){
        this.osRepository.deleteById(id);
    }


}
