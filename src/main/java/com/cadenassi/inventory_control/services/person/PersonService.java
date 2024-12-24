package com.cadenassi.inventory_control.services.person;

import com.cadenassi.inventory_control.dto.objects.person.PersonDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonService {
    @Transactional
    List<PersonDTO> getAllEmployees();
    @Transactional
    List<PersonDTO> getAllClients();
    @Transactional
    List<PersonDTO> getPersonByName(String name, String type);
    @Transactional
    PersonDTO getPersonByCpf(String cpf, String type);
    @Transactional
    PersonDTO insertPerson(String type, PersonDTO dto);
    @Transactional
    PersonDTO updatePerson(String cpf, PersonDTO dto);
    @Transactional
    void deletePersonByCpf(String cpf);
}
