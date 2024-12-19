package com.cadenassi.inventory_control.controllers.person;

import com.cadenassi.inventory_control.dto.objects.PersonDTO;
import com.cadenassi.inventory_control.proxy.person.PersonProxy;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/person/v1")
public class PersonController {

    @Autowired
    private PersonProxy proxy;

    @GetMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PersonDTO>> getAllEmployees(){
        return ResponseEntity.ok().body(proxy.getAllEmployees());
    }

    @GetMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PersonDTO>> getAllClients(){
        return ResponseEntity.ok().body(proxy.getAllClients());
    }

    @GetMapping(value = "/employee/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDTO> getEmployeeByCpf(@PathVariable(value = "cpf") String cpf){
        return ResponseEntity.ok().body(proxy.getPersonByCpf(cpf, "EMPLOYEE"));
    }

    @GetMapping(value = "/client/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDTO> getClientByCpf(@PathVariable(value = "cpf") String cpf){
        return ResponseEntity.ok().body(proxy.getPersonByCpf(cpf, "CLIENT"));
    }

    @GetMapping(value = "/employee", params = "name",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<List<PersonDTO>> getEmployeeByName(@PathParam(value = "name") String name){

        return ResponseEntity.ok().body(proxy.getPersonByName(name, "EMPLOYEE"));
    }

    @GetMapping(value = "/client", params = "name",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<List<PersonDTO>> getClientByName(@PathParam(value = "name") String name){

        return ResponseEntity.ok().body(proxy.getPersonByName(name, "CLIENT"));
    }

    @PostMapping(value = "/employee", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDTO> insertEmployee(@RequestBody PersonDTO person){
        return ResponseEntity.status(HttpStatus.CREATED).body(proxy.insertPerson("EMPLOYEE", person));
    }

    @PostMapping(value = "/client", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDTO> insertClient(@RequestBody PersonDTO person){
        return ResponseEntity.status(HttpStatus.CREATED).body(proxy.insertPerson("CLIENT", person));
    }

    @PutMapping(value = "/{cpf}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDTO> updatePersonByCpf(@PathVariable(value = "cpf") String cpf, @RequestBody PersonDTO dto){
        return ResponseEntity.ok().body(proxy.updatePerson(cpf, dto));
    }

    @DeleteMapping(value = "/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> deletePersonByCpf(@PathVariable(value = "cpf") String cpf){
        proxy.deletePersonByCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}
