package com.cadenassi.inventory_control.model.transactions.payment;

public class CreditCardPayment extends Payment{
    public CreditCardPayment(int numberInstallments) {
        super(true, numberInstallments);
    }
}
