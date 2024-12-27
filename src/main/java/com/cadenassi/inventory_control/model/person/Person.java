package com.cadenassi.inventory_control.model.person;

import com.cadenassi.inventory_control.model.transactions.sale.Sale;
import jakarta.persistence.*;


import javax.swing.text.DateFormatter;
import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Person implements Serializable {

    @Id
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private Instant created;

    @Column(name = "last_update")
    private Instant lastUpdate;

    public Person() {
    }

    public Person(String cpf, String name, String phoneNumber) {
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @PrePersist
    private void onCreate(){
        this.created = Instant.now().minus(3L, ChronoUnit.HOURS);
        this.lastUpdate = Instant.now().minus(3L, ChronoUnit.HOURS);
    }

    @PreUpdate
    private void onUpdate(){
        Instant.now().minus(3L, ChronoUnit.HOURS);
    }

    public abstract Set<Sale> getSales();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(cpf, person.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
