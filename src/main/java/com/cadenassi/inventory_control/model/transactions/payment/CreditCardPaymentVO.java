package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class CreditCardPaymentVO extends PaymentVO {
    public CreditCardPaymentVO(int numberInstallments) {
        super(true, numberInstallments, PaymentEnum.CREDIT_CARD);
    }
}
