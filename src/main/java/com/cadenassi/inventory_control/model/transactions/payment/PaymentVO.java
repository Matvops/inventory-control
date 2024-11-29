package com.cadenassi.inventory_control.model.transactions.payment;

import jakarta.persistence.Embeddable;

@Embeddable
public abstract class Payment {
    private boolean paid;
    private int numberInstallments;

    public Payment(boolean paid, int numberInstallments) {
        this.paid = paid;
        this.numberInstallments = numberInstallments;
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
}
