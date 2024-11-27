package com.cadenassi.inventory_control.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CategoryEnum {
    BLUSA(0),
    BONE(1),
    CROPPED(2),
    VESTIDO(3),
    CHINELO(4),
    JAQUETA(5),
    CALCA(6),
    CAMISA(7),
    SHORTS(8),
    SAIA(9),
    TENIS(10),
    MEIA(11),
    MOLETOM(12),
    REGATA(13),
    CAMISETA(14),
    INTIMA(15);

    private int i;

    private CategoryEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public CategoryEnum getCategory(int i){
        List<CategoryEnum> categories = new ArrayList<>(Arrays.asList(CategoryEnum.values()));

        return categories.get(i);
    }
}
