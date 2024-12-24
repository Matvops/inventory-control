package com.cadenassi.inventory_control.services.person;

import com.cadenassi.inventory_control.dto.mappers.PersonMapper;
import com.cadenassi.inventory_control.dto.objects.person.PersonDTO;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.model.person.Client;
import com.cadenassi.inventory_control.model.person.Employee;
import com.cadenassi.inventory_control.model.person.Person;
import com.cadenassi.inventory_control.repositories.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{


    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    @Override
    public List<PersonDTO> getAllEmployees() {
        log.info("Get all employees on PersonService");

        var employees = mapper.toListPersonDTO(repository.getAllEmployees().toArray(new Employee[0]));

        return employees;
    }

    @Override
    public List<PersonDTO> getAllClients() {
        log.info("Get all clients on PersonService");

        var clients = mapper.toListPersonDTO(repository.getAllClients().toArray(new Client[0]));

        return clients;
    }

    @Override
    public PersonDTO getPersonByCpf(String cpf, String type) {
        log.info("Get person by cpf on PersonService");

        var person = repository.getPersonByCpf(cpf, type);

        if(person == null) {
            throw new ResourceNotFoundException("PERSON WITH CPF INFORMED NOT FOUND!");
        }

        var dto = mapper.toPersonDTO(person);


        return dto;
    }

    @Override
    public List<PersonDTO> getPersonByName(String name, String type) {
        log.info("Get person by name on PersonService");

        List<PersonDTO> dtos = new ArrayList<>();

        var persons = repository.getPersonByName(name, type);


        if("CLIENT".equalsIgnoreCase(type)){
            dtos.addAll(mapper.toListPersonDTO(persons.toArray(new Client[0])));
        }


        if ("EMPLOYEE".equalsIgnoreCase(type)) {
            dtos.addAll(mapper.toListPersonDTO(persons.toArray(new Employee[0])));
        }

        return dtos;
    }

    @Override
    public PersonDTO insertPerson(String type, PersonDTO dto) {
        log.info("Insert person on PersonService");
        Person person = null;

        if("EMPLOYEE".equalsIgnoreCase(type)) {
            person = mapper.toEmployee(dto);
        }

        if("CLIENT".equalsIgnoreCase(type)) {
            person = mapper.toClient(dto);
        }

        var personDTO = mapper.toPersonDTO(repository.save(person));

        return personDTO;
    }

    @Override
    public PersonDTO updatePerson(String cpf, PersonDTO dto) {
        log.info("Update person by cpf on PersonService");
        var person = repository
                .findById(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("PERSON WITH CPF WAS NOT FOUND"));


        person.setName(dto.getName().toUpperCase());
        person.setPhoneNumber(dto.getPhoneNumber());

        var personDTO = mapper.toPersonDTO(repository.save(person));

        return personDTO;
    }

    @Override
    public void deletePersonByCpf(String cpf) {
        log.info("Delete person by cpf on PersonService");
        repository.deleteById(cpf);
    }
}
