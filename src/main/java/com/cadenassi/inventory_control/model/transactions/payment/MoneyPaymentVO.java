package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class MoneyPaymentVO extends PaymentVO {
    public MoneyPaymentVO() {
        super(true, 1, PaymentEnum.MONEY);
    }
}
