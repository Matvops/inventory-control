package com.cadenassi.inventory_control.model.transactions.sale;


import com.cadenassi.inventory_control.enums.PaymentEnum;
import com.cadenassi.inventory_control.model.person.Client;
import com.cadenassi.inventory_control.model.person.Employee;
import com.cadenassi.inventory_control.model.transactions.payment.Payment;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_sale")
public class Sale{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String observations;

    @Column(nullable = false)
    private Date date;

    private boolean paid;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToMany(mappedBy = "id.sale")
    private Set<SaleItem> items = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Sale(Payment payment, float price, Date date, String observations, boolean paid) {
        this.price = price;
        this.date = date;
        this.observations = observations;
        this.payment = payment;
        setPaid(paid);
    }

    public void total(){
        this.items.forEach(x -> this.price += x.subTotal());
    }

    public Long getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<SaleItem> getItems() {
        return items;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        if(!getPayment().getPayment().equals(PaymentEnum.ON_THE_CUFF)) {
            this.paid = false;
            return;
        }

        this.paid = true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
