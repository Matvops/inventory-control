package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class OnTheCuffPayment extends Payment {
    public OnTheCuffPayment(int numberInstallments) {
        super(false, numberInstallments, PaymentEnum.ON_THE_CUFF);
    }
}
