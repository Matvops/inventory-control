package com.cadenassi.inventory_control.proxy.person;

import com.cadenassi.inventory_control.dto.objects.person.PersonDTO;
import com.cadenassi.inventory_control.exceptions.InvalidArgumentException;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.proxy.GenericServiceProxy;
import com.cadenassi.inventory_control.services.person.PersonService;
import com.cadenassi.inventory_control.services.person.PersonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonProxy extends GenericServiceProxy implements PersonService {


    private static final Logger log = LoggerFactory.getLogger(PersonProxy.class);

    @Autowired
    private PersonServiceImpl service;

    @Override
    public List<PersonDTO> getAllEmployees() {
        log.info("get all employees on proxy");
        return service.getAllEmployees();
    }

    @Override
    public List<PersonDTO> getAllClients() {
        log.info("get all clients on proxy");
        return service.getAllClients();
    }

    @Override
    public PersonDTO getPersonByCpf(String cpf, String type) {
        log.info("check the cpf and type, in the proxy getPersonByCpf");
        verifyIsNull(cpf);
        verifyIsNull(type);
        verifyIsNumber(cpf);

        if(cpf.length() != 11) {
            throw new InvalidArgumentException("CPF LENGTH IS DIFFERENT FROM 11");
        }

        if("EMPLOYEE".equalsIgnoreCase(type) || "CLIENT".equalsIgnoreCase(type)) {
            return service.getPersonByCpf(cpf, type.toUpperCase());
        }

        throw new ResourceNotFoundException("TYPE " + type + " NOT FOUND!");
    }

    @Override
    public List<PersonDTO> getPersonByName(String name, String type) {
        log.info("check name and type, in the proxy getPersonByName");
        verifyIsNull(name);
        verifyIsNull(type);

        if("EMPLOYEE".equalsIgnoreCase(type) || "CLIENT".equalsIgnoreCase(type)) {
            return service.getPersonByName(name, type.toUpperCase());
        }

        throw new ResourceNotFoundException("TYPE " + type + " NOT FOUND!");
    }


    @Override
    public PersonDTO insertPerson(String type, PersonDTO dto) {
        log.info("check type and personDTO, in the proxy insertPerson");
        verifyIsNull(type);
        verifyIsNull(dto);
        verifyIsNull(dto.getCpf());
        verifyIsNull(dto.getName());

        if(dto.getCpf().length() != 11) {
            throw new InvalidArgumentException("CPF LENGTH IS DIFFERENT FROM 11");
        }

        if(dto.getPhoneNumber() != null) {
            verifyIsNumber(dto.getPhoneNumber());
        }

        if("EMPLOYEE".equalsIgnoreCase(type) || "CLIENT".equalsIgnoreCase(type)) {
            return service.insertPerson(type.toUpperCase(), dto);
        }

        throw new ResourceNotFoundException("TYPE " + type + " NOT FOUND!");
    }

    @Override
    public PersonDTO updatePerson(String cpf, PersonDTO dto) {
        log.info("check cpf and productDTO, in the proxy updatePerson");
        verifyIsNull(cpf);
        verifyIsNull(dto);
        verifyIsNumber(cpf);

        if(dto.getPhoneNumber() != null) {
            verifyIsNumber(dto.getPhoneNumber());
        }


        if(cpf.length() != 11) {
            throw new InvalidArgumentException("CPF LENGTH IS DIFFERENT FROM 11");
        }

        return service.updatePerson(cpf, dto);
    }

    @Override
    public void deletePersonByCpf(String cpf) {
        log.info("check cpf, in the proxy deletePersonById");
        verifyIsNull(cpf);
        verifyIsNumber(cpf);

        if(cpf.length() != 11) {
            throw new InvalidArgumentException("CPF LENGTH IS DIFFERENT FROM 11");
        }

        service.deletePersonByCpf(cpf);
    }
}
