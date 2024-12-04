package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class PixPayment extends Payment {
    public PixPayment() {
        super(1, PaymentEnum.PIX);
    }
}
