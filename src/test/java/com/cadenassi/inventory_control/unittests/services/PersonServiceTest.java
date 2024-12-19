package com.cadenassi.inventory_control.unittests.services;

import com.cadenassi.inventory_control.dto.mappers.PersonMapper;
import com.cadenassi.inventory_control.dto.objects.PersonDTO;
import com.cadenassi.inventory_control.model.person.Client;
import com.cadenassi.inventory_control.model.person.Employee;
import com.cadenassi.inventory_control.model.person.Person;
import com.cadenassi.inventory_control.repositories.person.PersonRepository;
import com.cadenassi.inventory_control.services.person.PersonServiceImpl;
import com.cadenassi.inventory_control.unittests.mocks.person.MockPerson;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @Mock
    PersonMapper mapper;

    @Mock
    PersonRepository repository;

    @InjectMocks
    PersonServiceImpl service;

    MockPerson mock;

    @BeforeEach
    void setUp() {
        mock = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @Order(0)
    void getPersonByCpf(){
        //ARRANGE
        var cpf = "00000000000";
        Person person = mock.getPerson(cpf, "EMPLOYEE");
        PersonDTO dto = mock.getPersonDTO(cpf);

        when(repository.getPersonByCpf(cpf, "EMPLOYEE")).thenReturn(person);
        when(mapper.toPersonDTO(person)).thenReturn(dto);

        //ACT
        service.getPersonByCpf(cpf, "EMPLOYEE");

        //ASSERTIONS
        verify(repository, times(1)).getPersonByCpf(eq(cpf), eq("EMPLOYEE"));
    }

    @Test
    @Order(1)
    void getPersonByName(){
        //ARRANGE
        var persons = (List<Employee>) mock.getListPerson("EMPLOYEE");
        List<PersonDTO> dtos = mock.getPersonDTOs();
        var name = "NAME";
        var type = "EMPLOYEE";

        when(repository.getPersonByName(name, type)).thenAnswer(invocationOnMock -> persons);
        when(mapper.toListPersonDTO(persons.toArray(new Employee[0]))).thenReturn(dtos);

        //ACT

        service.getPersonByName(name, type);

        //ASSERTIONS
        verify(repository, atLeastOnce()).getPersonByName(name, type);
    }

    @Test
    @Order(2)
    void insertPersonTest(){
        //ARRANGE

            var type = "EMPLOYEE";
            Employee person = (Employee) mock.getPerson(type);
            var dto = mock.getPersonDTO();

            when(repository.save(person)).thenReturn(person);
            when(mapper.toPersonDTO(person)).thenReturn(dto);
            when(mapper.toEmployee(dto)).thenReturn(person);
        //ACT

            service.insertPerson(type, dto);

        //ASSERTIONS

            verify(repository, times(1)).save(eq(person));
            verify(mapper, atLeast(1)).toEmployee(dto);
    }
}
