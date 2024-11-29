package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class DebitCardPaymentVO extends PaymentVO {

    public DebitCardPaymentVO() {
        super(true, 1, PaymentEnum.DEBIT_CARD);
    }
}
