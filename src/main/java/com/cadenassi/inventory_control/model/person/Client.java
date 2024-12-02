package com.cadenassi.inventory_control.model.person;

import com.cadenassi.inventory_control.model.transactions.sale.Sale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "CLIENT")
public class Client extends Person{

    @OneToMany(mappedBy = "client")
    private Set<Sale> sales = new HashSet<>();

    public Client(String CPF, String name, String phoneNumber) {
        super(CPF, name, phoneNumber);
    }

    @Override
    public Set<Sale> getSales() {
        return sales;
    }
}
