package com.cadenassi.inventory_control.model.transactions.purchase;

import com.cadenassi.inventory_control.model.person.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Embeddable
public class PurchaseVO implements Serializable {

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "id.purchase")
    private Set<PurchaseItem> items = new HashSet<>();

    public PurchaseVO() {}

    public PurchaseVO(Float price, String description, Employee employee) {
        this.price = price;
        this.description = description;
        this.employee = employee;
    }

    public void total(){
        this.items.forEach(x -> this.price =+ x.subTotal());
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

    public Employee getEmployee() {
        return employee;
    }

    protected void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseVO that = (PurchaseVO) o;
        return Objects.equals(price, that.price) && Objects.equals(description, that.description) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, description, employee);
    }
}