package com.cadenassi.inventory_control.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BrandEnum {
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

    public static BrandEnum getClothing(int i){
        List<BrandEnum> brandEnums = new ArrayList<>(Arrays.asList(BrandEnum.values()));

        return brandEnums.get(i);
    }
}
