package com.cadenassi.inventory_control.repositories.person;

import com.cadenassi.inventory_control.model.person.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
