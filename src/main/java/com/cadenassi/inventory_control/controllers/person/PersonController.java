package com.cadenassi.inventory_control.controllers.person;

import com.cadenassi.inventory_control.dto.objects.person.PersonDTO;
import com.cadenassi.inventory_control.proxy.person.PersonProxy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(name = "Employees", description = "EMPLOYEE CONTROLLER")
    @Operation(summary = "GET ALL EMPLOYEES", description = "METHOD TO GET ALL EMPLOYEES", responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<List<PersonDTO>> getAllEmployees() {
        return ResponseEntity.ok().body(proxy.getAllEmployees());
    }


    @GetMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Clients", description = "Clients Controller")
    @Operation(summary = "GET ALL CLIENTS", description = "METHOD TO GET ALL CLIENTS", responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<List<PersonDTO>> getAllClients() {
        return ResponseEntity.ok().body(proxy.getAllClients());
    }


    @GetMapping(value = "/employee/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Employees", description = "EMPLOYEE CONTROLLER")
    @Operation(summary = "GET EMPLOYEE BY CPF", description = "METHOD TO GET EMPLOYEE BY CPF", responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , schema = @Schema(implementation = PersonDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<PersonDTO> getEmployeeByCpf(@PathVariable(value = "cpf") String cpf) {
        return ResponseEntity.ok().body(proxy.getPersonByCpf(cpf, "EMPLOYEE"));
    }


    @GetMapping(value = "/client/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Clients", description = "Clients Controller")
    @Operation(summary = "GET CLIENT BY CPF", description = "METHOD TO GET CLIENT BY CPF", responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , schema = @Schema(implementation = PersonDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<PersonDTO> getClientByCpf(@PathVariable(value = "cpf") String cpf) {
        return ResponseEntity.ok().body(proxy.getPersonByCpf(cpf, "CLIENT"));
    }


    @GetMapping(value = "/employee", params = "name",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Employees", description = "EMPLOYEE CONTROLLER")
    @Operation(summary = "GET EMPLOYEES BY NAME", description = "METHOD TO GET EMPLOYEES BY NAME, NAME ISN'T CASE SENSITIVE"
            , responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<List<PersonDTO>> getEmployeeByName(@PathParam(value = "name") String name) {

        return ResponseEntity.ok().body(proxy.getPersonByName(name, "EMPLOYEE"));
    }


    @GetMapping(value = "/client", params = "name",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Clients", description = "Clients Controller")
    @Operation(summary = "GET CLIENTS BY NAME", description = "METHOD TO GET CLIENTS BY NAME, NAME ISN'T CASE SENSITIVE"
            , responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESSFULLY RETURNED"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<List<PersonDTO>> getClientByName(@PathParam(value = "name") String name) {

        return ResponseEntity.ok().body(proxy.getPersonByName(name, "CLIENT"));
    }


    @PostMapping(value = "/employee", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Employees", description = "EMPLOYEE CONTROLLER")
    @Operation(summary = "INSERT EMPLOYEE", description = "METHOD TO INSERT EMPLOYEE", responses = {
            @ApiResponse(responseCode = "201", description = "CREATED SUCCESSFULLY"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , schema = @Schema(implementation = PersonDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<PersonDTO> insertEmployee(@RequestBody PersonDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proxy.insertPerson("EMPLOYEE", person));
    }


    @PostMapping(value = "/client", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Clients", description = "Clients Controller")
    @Operation(summary = "INSERT CLIENT", description = "METHOD TO INSERT CLIENT", responses = {
            @ApiResponse(responseCode = "201", description = "CREATED SUCCESSFULLY"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , schema = @Schema(implementation = PersonDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<PersonDTO> insertClient(@RequestBody PersonDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proxy.insertPerson("CLIENT", person));
    }


    @PutMapping(value = "/{cpf}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Persons", description = "Persons Controller")
    @Operation(summary = "UPDATE PERSON BY CPF", description = "METHOD TO PERSON BY CPF", responses = {
            @ApiResponse(responseCode = "200", description = "UPDATED SUCCESSFULLY"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = PersonDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<PersonDTO> updatePersonByCpf(@PathVariable(value = "cpf") String cpf, @RequestBody PersonDTO dto) {
        return ResponseEntity.ok().body(proxy.updatePerson(cpf, dto));
    }


    @DeleteMapping(value = "/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Tag(name = "Persons", description = "Persons Controller")
    @Operation(summary = "DELETE PERSON BY CPF", description = "METHOD TO DELETE PERSON BY CPF"
            , responses = {
            @ApiResponse(responseCode = "204", description = "DELETED SUCCESSFULLY"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema)),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema))
    })
    public ResponseEntity<Void> deletePersonByCpf(@PathVariable(value = "cpf") String cpf) {
        proxy.deletePersonByCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}
