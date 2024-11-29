package com.cadenassi.inventory_control.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MaterialEnum {
    ALGODAO,
    COURO,
    DRY_FIT,
    JEANS,
    SOCIAL,
    MOLETOM,
    POLIESTER,
    PRIMEIRA_LINHA,
    SEGUNDA_LINHA,
    TACTEL;

    public MaterialEnum getMaterial(int i){
        List<MaterialEnum> materials = new ArrayList<>(Arrays.asList(MaterialEnum.values()));

        return materials.get(i);
    }
}
