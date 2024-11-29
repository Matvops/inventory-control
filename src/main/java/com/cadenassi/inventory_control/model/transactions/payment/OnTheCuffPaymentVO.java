package com.cadenassi.inventory_control.model.transactions.payment;

public class OnTheCuffPayment extends Payment{
    public OnTheCuffPayment(int numberInstallments) {
        super(false, numberInstallments);
    }
}
