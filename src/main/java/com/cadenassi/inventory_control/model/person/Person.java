package com.cadenassi.inventory_control.model.person;

import com.cadenassi.inventory_control.model.transactions.sale.Sale;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Person implements Serializable {

    @Id
    private String CPF;

    @Column(nullable = false)
    private String name;

    private String phoneNumber;

    public Person() {
    }

    public Person(String CPF, String name, String phoneNumber) {
        this.CPF = CPF;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract Set<Sale> getSales();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(CPF, person.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CPF);
    }
}
