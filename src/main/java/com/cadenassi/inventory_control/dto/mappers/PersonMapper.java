package com.cadenassi.inventory_control.dto.mappers;

import com.cadenassi.inventory_control.dto.objects.ClientDTO;
import com.cadenassi.inventory_control.dto.objects.EmployeeDTO;
import com.cadenassi.inventory_control.dto.objects.PersonDTO;
import com.cadenassi.inventory_control.model.person.Client;
import com.cadenassi.inventory_control.model.person.Employee;
import com.cadenassi.inventory_control.model.person.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Employee toEmployee(PersonDTO dto);

    Client toClient(PersonDTO dto);

    PersonDTO toPersonDTO(Employee person);

    PersonDTO toPersonDTO(Person person);

    List<Employee> toListEmployee(PersonDTO... dtos);

    List<Client> toListClient(PersonDTO... dtos);

    List<PersonDTO> toListPersonDTO(Employee... persons);

    List<PersonDTO> toListPersonDTO(Client... persons);
}