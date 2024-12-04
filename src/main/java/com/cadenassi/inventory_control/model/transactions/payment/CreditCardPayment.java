package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(int numberInstallments) {
        super(numberInstallments, PaymentEnum.CREDIT_CARD);
    }
}
