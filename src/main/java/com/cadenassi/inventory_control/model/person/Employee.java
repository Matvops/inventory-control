package com.cadenassi.inventory_control.model.person;

import com.cadenassi.inventory_control.model.transactions.sale.Sale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "EMPLOYEE")
public class Employee extends Person {

    @OneToMany(mappedBy = "employee")
    private Set<Sale> sales = new HashSet<>();

    public Employee(String CPF, String name, String phoneNumber) {
        super(CPF, name, phoneNumber);
    }

    @Override
    public Set<Sale> getSales() {
        return sales;
    }
}
