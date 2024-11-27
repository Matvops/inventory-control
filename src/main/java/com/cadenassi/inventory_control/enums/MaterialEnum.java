package com.cadenassi.inventory_control.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MaterialEnum {
    ALGODAO(0),
    COURO(1),
    DRY_FIT(2),
    JEANS(3),
    SOCIAL(4),
    MOLETOM(5),
    POLIESTER(6),
    PRIMEIRA_LINHA(7),
    SEGUNDA_LINHA(8),
    TACTEL(9);

    private int i;

    private MaterialEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public MaterialEnum getMaterial(int i){
        List<MaterialEnum> materials = new ArrayList<>(Arrays.asList(MaterialEnum.values()));

        return materials.get(i);
    }
}
