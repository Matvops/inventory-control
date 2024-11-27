package com.cadenassi.inventory_control.model.product;

import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "category")
class Category implements Serializable {
    //ATUALIZAR OU NÃO PARA V.O

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    private CategoryEnum category;

    @Column(name = "material", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
