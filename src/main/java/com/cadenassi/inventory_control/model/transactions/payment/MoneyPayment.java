package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class MoneyPayment extends Payment {
    public MoneyPayment() {
        super(1, PaymentEnum.MONEY);
    }
}
