package com.cadenassi.inventory_control.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CategoryEnum {
    BLUSA,
    BONE,
    CROPPED,
    VESTIDO,
    CHINELO,
    JAQUETA,
    CALCA,
    CAMISA,
    SHORTS,
    SAIA,
    TENIS,
    MEIA,
    MOLETOM,
    REGATA,
    CAMISETA,
    INTIMA;

    public CategoryEnum getCategory(int i){
        List<CategoryEnum> categories = new ArrayList<>(Arrays.asList(CategoryEnum.values()));

        return categories.get(i);
    }
}
