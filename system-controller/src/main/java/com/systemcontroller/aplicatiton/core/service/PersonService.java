package com.systemcontroller.aplicatiton.core.service;

import com.systemcontroller.aplicatiton.core.configuration.GenericEntity_;
import com.systemcontroller.aplicatiton.core.configuration.GenericObjectMapper;
import com.systemcontroller.aplicatiton.dto.PersonDto;
import com.systemcontroller.domain.model.Person;
import com.systemcontroller.domain.objectValue.IOrderService;
import com.systemcontroller.insfrastructure.http.PersonException;
import com.systemcontroller.insfrastructure.repositories.IPersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IOrderService {

    private final String NO_FOUND_MSG = "Order não encontrada na base de dados";
    private final String ERROR_SERVER = "Houve um erro no servidor tente novamente mais tarde";

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private IPersonRepository personRepository;



    public Page<PersonDto> bringAll(Integer page, Integer pageSize){
            return this.mapper.mapEntityPageIntoDtoPage(
                    this.personRepository.findAll(PageRequest.of(page, pageSize, Sort.by("id"))), PersonDto.class);
    }

    public PersonDto bringByid(Integer id){
        Person person = this.personRepository.findById(id)
                .orElseThrow(()-> new PersonException(NO_FOUND_MSG, HttpStatus.NOT_FOUND));
        return  this.mapper.mapTo(person, PersonDto.class);
    }

    public PersonDto saveObject(Object obj){
        Person person = this.mapper.mapTo(obj, Person.class);
        this.personRepository.save(person);
        return this.bringByid(person.getId());
    }

    public PersonDto updateObject(Object obj){
        PersonDto companyDto =  this.mapper.mapTo(obj, PersonDto.class);
        Person newPerson =  this.personRepository.save(
                this.mapper.mapTo(companyDto, Person.class));

        Person serarchPerson = this.personRepository.findById(companyDto.getId())
                .orElseThrow(()-> new PersonException(NO_FOUND_MSG, HttpStatus.NOT_FOUND));

        BeanUtils.copyProperties(newPerson, serarchPerson, GenericEntity_.ID, GenericEntity_.IDENTIFY,
                GenericEntity_.CREATED_AT, GenericEntity_.DELIVERY_DATE);

        return this.mapper.mapTo(
                this.personRepository.save(newPerson), PersonDto.class);
    }

    public void deleteObject(Integer id){
        this.personRepository.deleteById(id);
    }

    public PersonDto creatOrderService(Integer id, Object obj) {
        return null;
    }

}
