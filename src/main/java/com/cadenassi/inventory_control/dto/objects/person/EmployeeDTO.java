package com.cadenassi.inventory_control.dto.objects.person;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class EmployeeDTO implements Serializable {
    private String cpf;
    private String name;
    private String phoneNumber;
    private Instant created;
    private Instant lastUpdate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String cpf, String name, String phoneNumber, Instant created, Instant lastUpdate) {
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }

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
}
