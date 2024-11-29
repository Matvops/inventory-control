package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public abstract class PaymentVO implements Serializable {
    private boolean paid;
    private int numberInstallments;
    private PaymentEnum payment;

    public PaymentVO(boolean paid, int numberInstallments, PaymentEnum payment) {
        this.paid = paid;
        this.numberInstallments = numberInstallments;
        this.payment = payment;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PaymentVO paymentVO = (PaymentVO) o;
        return paid == paymentVO.paid && numberInstallments == paymentVO.numberInstallments && payment == paymentVO.payment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paid, numberInstallments, payment);
    }
}
