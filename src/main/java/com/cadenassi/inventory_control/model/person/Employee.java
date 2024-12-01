package com.cadenassi.inventory_control.model.person;

import com.cadenassi.inventory_control.model.transactions.sale.Sale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_employee")
public class Employee extends Person {

    @Id
    private String CPF;

    @OneToMany(mappedBy = "employee")
    private Set<Sale> sales = new HashSet<>();


    public Employee(String name, String phoneNumber, String CPF) {
        super(name, phoneNumber);
        this.CPF = CPF;
    }

    @Override
    public String getCPF() {
        return this.CPF;
    }

    @Override
    public void setCPF(String cpf) {
        this.CPF = cpf;
    }

    @JsonIgnore
    public Set<Sale> getSales() {
        return sales;
    }
}
