package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;
import com.cadenassi.inventory_control.model.transactions.sale.Sale;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public abstract class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_installment")
    private int numberInstallments;

    @OneToMany(mappedBy = "payment")
    private List<Sale> sales = new ArrayList<>();

    private PaymentEnum payment;

    public Payment(int numberInstallments, PaymentEnum payment) {
        this.numberInstallments = numberInstallments;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberInstallments() {
        return numberInstallments;
    }

    public void setNumberInstallments(int numberInstallments) {
        this.numberInstallments = numberInstallments;
    }

    public PaymentEnum getPayment() {
        return payment;
    }

    public void setPayment(PaymentEnum payment) {
        this.payment = payment;
    }

    public List<Sale> getSales() {
        return sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
