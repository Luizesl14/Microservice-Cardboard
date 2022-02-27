package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.domain.shared.GenericEntity_;
import com.systemcontroller.domain.shared.GenericObjectMapper;
import com.systemcontroller.aplicatiton.dto.CompanyDto;
import com.systemcontroller.aplicatiton.dto.OrderDto;
import com.systemcontroller.domain.model.Company;
import com.systemcontroller.domain.objectValue.IOrderService;
import com.systemcontroller.insfrastructure.http.CompanyException;
import com.systemcontroller.insfrastructure.repositories.ICompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements IOrderService {

    private final String NO_FOUND_MSG = "Order não encontrada na base de dados";
    private final String ERROR_SERVER = "Houve um erro no servidor tente novamente mais tarde";

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ICompanyRepository companyRepository;


    public Page<CompanyDto> bringAll(Integer page, Integer pageSize){
            return this.mapper.mapEntityPageIntoDtoPage(
                    this.companyRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id"))), CompanyDto.class);
    }

    public CompanyDto bringByid(Integer id){
        Company company = this.companyRepository.findById(id)
                .orElseThrow(()-> new CompanyException(NO_FOUND_MSG, HttpStatus.NOT_FOUND));
        return  this.mapper.mapTo(company, CompanyDto.class);
    }

    public CompanyDto saveObject(Object obj){
        Company company = this.mapper.mapTo(obj, Company.class);
        this.companyRepository.save(company);
        return this.bringByid(company.getId());
    }

    public CompanyDto updateObject(Object obj){
        CompanyDto companyDto =  this.mapper.mapTo(obj, CompanyDto.class);
        Company newCompany =  this.companyRepository.save(
                this.mapper.mapTo(companyDto, Company.class));

        Company serarchCompany = this.companyRepository.findById(companyDto.getId())
                .orElseThrow(()-> new CompanyException(NO_FOUND_MSG, HttpStatus.NOT_FOUND));

        BeanUtils.copyProperties(newCompany, serarchCompany, GenericEntity_.ID, GenericEntity_.IDENTIFY,
                GenericEntity_.CREATED_AT, GenericEntity_.DELIVERY_DATE);

        return this.mapper.mapTo(
                this.companyRepository.save(newCompany), CompanyDto.class);
    }

    public void deleteObject(Integer id){
        this.companyRepository.deleteById(id);
    }

    public OrderDto creatOrderService(Integer id, Object obj) {
        return null;
    }

}
