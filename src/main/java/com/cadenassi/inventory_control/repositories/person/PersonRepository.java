package com.cadenassi.inventory_control.repositories.person;

import com.cadenassi.inventory_control.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
