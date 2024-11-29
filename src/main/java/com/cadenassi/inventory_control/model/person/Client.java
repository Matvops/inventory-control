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
@Table(name = "tb_client")
public class Client extends Person{

    @Id
    private String CPF;

    @OneToMany(mappedBy = "client")
    private Set<Sale> sales = new HashSet<>();

    public Client(String name, String phoneNumber, String CPF) {
        super(name, phoneNumber);
        this.CPF = CPF;
    }

    @Override
    public String getCPF() {
        return this.CPF;
    }

    @Override
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @JsonIgnore
    public Set<Sale> getSales() {
        return sales;
    }
}
