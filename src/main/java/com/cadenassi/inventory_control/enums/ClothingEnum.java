package com.cadenassi.inventory_control.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ClothingEnum {
    ADIDAS(0),
    CALVIN_KLEIN(1),
    CONVERSE(2),
    COLCCI(3),
    GUCCI(4),
    KENNER(5),
    LACOSTE(6),
    LOUIS_VUITTON(7),
    MIZUNO(8),
    NIKE(9),
    OAKLEY(10),
    OUS(11),
    PUMA(12),
    PRADA(13),
    QUICK_SILVER(14),
    TOMMY_HILFIGER(15);

    private int i;

    private ClothingEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public ClothingEnum getClothing(int i){
        List<ClothingEnum> clothingEnums = new ArrayList<>(Arrays.asList(ClothingEnum.values()));

        return clothingEnums.get(i);
    }
}
