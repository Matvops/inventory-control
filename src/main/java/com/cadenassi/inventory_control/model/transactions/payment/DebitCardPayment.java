package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class DebitCardPayment extends Payment {

    public DebitCardPayment() {
        super( 1, PaymentEnum.DEBIT_CARD);
    }
}
