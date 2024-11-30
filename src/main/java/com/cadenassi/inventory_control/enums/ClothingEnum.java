package com.cadenassi.inventory_control.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ClothingEnum {
    ADIDAS,
    CALVIN_KLEIN,
    CONVERSE,
    COLCCI,
    GUCCI,
    KENNER,
    LACOSTE,
    LOUIS_VUITTON,
    MIZUNO,
    NIKE,
    OAKLEY,
    OUS,
    PUMA,
    PRADA,
    QUICK_SILVER,
    TOMMY_HILFIGER;

    public static ClothingEnum getClothing(int i){
        List<ClothingEnum> clothingEnums = new ArrayList<>(Arrays.asList(ClothingEnum.values()));

        return clothingEnums.get(i);
    }
}
