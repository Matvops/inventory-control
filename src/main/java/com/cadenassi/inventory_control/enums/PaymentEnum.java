package com.cadenassi.inventory_control.enums;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PaymentEnum {
    CREDIT_CARD,
    DEBIT_CARD,
    MONEY,
    ON_THE_CUFF,
    PIX;

    public static PaymentEnum getPayment(int i){
        List<PaymentEnum> payments = new ArrayList<>(Arrays.asList(PaymentEnum.values()));

        return payments.get(i);
    }
}
