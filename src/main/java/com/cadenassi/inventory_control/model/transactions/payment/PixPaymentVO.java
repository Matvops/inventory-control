package com.cadenassi.inventory_control.model.transactions.payment;

import com.cadenassi.inventory_control.enums.PaymentEnum;

public class PixPaymentVO extends PaymentVO {
    public PixPaymentVO() {
        super(true, 1, PaymentEnum.PIX);
    }
}
