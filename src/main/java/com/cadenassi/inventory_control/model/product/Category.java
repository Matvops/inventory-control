package com.cadenassi.inventory_control.model.product;

import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Category implements Serializable {

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Enumerated(EnumType.STRING)
    private MaterialEnum material;


    public Category() {}

    public Category(CategoryEnum category, MaterialEnum material) {
        this.category = category;
        this.material = material;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public MaterialEnum getMaterial() {
        return material;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public void setMaterial(MaterialEnum material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category1 = (Category) o;
        return category == category1.category && material == category1.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, material);
    }
}
