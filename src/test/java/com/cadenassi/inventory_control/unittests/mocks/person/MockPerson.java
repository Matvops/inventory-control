package com.cadenassi.inventory_control.unittests.mocks.person;

import com.cadenassi.inventory_control.dto.objects.PersonDTO;
import com.cadenassi.inventory_control.model.person.Client;
import com.cadenassi.inventory_control.model.person.Employee;
import com.cadenassi.inventory_control.model.person.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {


    public Person getPerson(String type) {
        return getPerson("00000000000", type);
    }

    public PersonDTO getPersonDTO() {
        return getPersonDTO("00000000000");
    }

    public Person getPerson(String cpf, String type) {
        Person person = null;

        if("EMPLOYEE".equalsIgnoreCase(type)) {
            person = new Employee();
            person.setCpf(cpf);
            person.setName("NAME" + cpf);
            person.setPhoneNumber("NUMBER" + cpf);

        }

        if("CLIENT".equalsIgnoreCase(type)){
            person = new Client();
            person.setCpf(cpf);
            person.setName("NAME" + cpf);
            person.setPhoneNumber("NUMBER" + cpf);
        }



        return person;
    }


    public PersonDTO getPersonDTO(String cpf) {
        var dto = new PersonDTO();

        dto.setCpf(cpf);
        dto.setName("NAME" + cpf);
        dto.setPhoneNumber("NUMBER" + cpf);

        return dto;
    }

    public List<? extends Person> getListPerson(String type) {
        List<Person> persons = new ArrayList<>();
        String cpf;

        for (int i = 0; i < 10; i++) {
            cpf = "";
            for(int j = 0; j < 11; j++){
                cpf += i;
            }
            persons.add(getPerson(cpf, type));
        }

        return persons;
    }

    public List<PersonDTO> getPersonDTOs(){
        List<PersonDTO> dtos = new ArrayList<>();
        String cpf;

        for (int i = 0; i < 10; i++) {
            cpf = "";
            for (int j = 0; j < 11; j++) {
                cpf += i;
            }
            dtos.add(getPersonDTO(cpf));
        }

        return dtos;
    }
}
