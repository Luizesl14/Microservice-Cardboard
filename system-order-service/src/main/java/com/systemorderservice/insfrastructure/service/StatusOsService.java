package com.systemorderservice.insfrastructure.service;

import com.systemorderservice.aplicatiton.dto.StatusOsTypeDto;
import com.systemorderservice.domain.entity.StatusOsType;
import com.systemorderservice.domain.repository.StatusOsRepository;
import model.GenericEntity_;
import model.GenericObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusOsService {

    private final GenericObjectMapper mapper = new GenericObjectMapper();

    @Autowired
    private StatusOsRepository statusOsRepository;

    public List<StatusOsTypeDto> findAllStatus(){
        return this.mapper.mapListTo(this.statusOsRepository.findAll(), StatusOsTypeDto.class);
    }

    public StatusOsTypeDto findIdStatus(Long id){
        StatusOsType status = this.statusOsRepository.findById(id).orElseThrow(()-> new RuntimeException(("ORDEM DE SERVICO - NOT FOUND")));
        return  this.mapper.mapTo(status, StatusOsTypeDto.class);
    }

    public StatusOsTypeDto saveStatus(StatusOsTypeDto statusOsTypeDto){
        this.statusOsRepository.save(this.mapper.mapTo(statusOsTypeDto, StatusOsType.class));
        return  this.findIdStatus(statusOsTypeDto.getId());
    }

    public StatusOsTypeDto updateStatus(StatusOsTypeDto statusOsTypeDto){
        StatusOsType newStatus =  this.statusOsRepository.save(this.mapper.mapTo(statusOsTypeDto, StatusOsType.class));
        StatusOsType serarchStatus = this.statusOsRepository.findById(statusOsTypeDto.getId()).orElseThrow(
               ()-> new RuntimeException("RDEM DE SERVICO - NOT FOUND")
       );
        BeanUtils.copyProperties(newStatus, serarchStatus, GenericEntity_.ID);
        return this.mapper.mapTo(this.statusOsRepository.save(newStatus), StatusOsTypeDto.class) ;

    }

    public void deleteStatus(Long id){
        this.statusOsRepository.deleteById(id);
    }


}
