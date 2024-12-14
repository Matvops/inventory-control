package com.cadenassi.inventory_control.repositories.person;

import com.cadenassi.inventory_control.model.person.Person;
import com.cadenassi.inventory_control.model.product.Product;
import org.hibernate.annotations.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    @Query(value = "SELECT * FROM vw_employee", nativeQuery = true)
    List<Product> getAllEmployees();

    @Query(value = "SELECT * FROM vw_client", nativeQuery = true)
    List<Product> getAllClients();

    @Procedure(procedureName = "get_person_by_name")
    List<Product> getPersonByName(@Param("name") String name, @Param("type") String type);
}
