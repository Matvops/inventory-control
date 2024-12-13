package com.cadenassi.inventory_control.model.transactions.purchase;

import com.cadenassi.inventory_control.model.person.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "purchase")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String description;

    @Column
    private Date created;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "id.purchase")
    private final Set<PurchaseItem> items = new HashSet<>();

    public Purchase() {}

    public Purchase(String description, Float price) {
        this.description = description;
        this.price = price;
    }

    @PrePersist
    private void onCreate(){
        this.created = new Date();
        this.lastUpdate = new Date();
    }

    @PreUpdate
    private void onUpdate(){
        this.lastUpdate = new Date();
    }

    public void total(){
        this.items.forEach(x -> this.price =+ x.subTotal());
    }

    public Long getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    protected void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PurchaseItem> getItems() {
        return items;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}