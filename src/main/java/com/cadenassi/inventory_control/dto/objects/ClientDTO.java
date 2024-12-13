package com.cadenassi.inventory_control.dto.objects;

import java.io.Serializable;
import java.util.Date;

public class ClientDTO implements Serializable {
    private String cpf;
    private String name;
    private String phoneNumber;
    private Date created;
    private Date lastUpdate;

    public ClientDTO() {
    }

    public ClientDTO(String cpf, String name, String phoneNumber, Date created, Date lastUpdate) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
