package com.cadenassi.inventory_control.model.transactions.sale;


import com.cadenassi.inventory_control.model.transactions.payment.PaymentVO;
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

    @Embedded
    private PaymentVO payment;

    @OneToMany(mappedBy = "id.sale")
    private Set<SaleItem> items = new HashSet<>();

    public Sale(PaymentVO payment, float price, Date date, String observations) {
        this.price = price;
        this.date = date;
        this.observations = observations;
        this.payment = payment;
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

    public PaymentVO getPayment() {
        return payment;
    }

    public void setPayment(PaymentVO payment) {
        this.payment = payment;
    }

    public Set<SaleItem> getItems() {
        return items;
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
