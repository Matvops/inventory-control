package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class OnTheCuffPaymentVO extends PaymentVO {
    public OnTheCuffPaymentVO(int numberInstallments) {
        super(false, numberInstallments, PaymentEnum.ON_THE_CUFF);
    }
}
