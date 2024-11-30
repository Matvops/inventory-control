package com.cadenassi.inventory_control.dto.objects;

import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.model.product.Category;

import java.io.Serializable;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private Integer quantity;
    private Float price;
    private ClothingEnum clothing;
    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(String name, Integer quantity, Float price, ClothingEnum clothing,
                      CategoryEnum categoryEnum, MaterialEnum materialEnum) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.clothing = clothing;
        this.category = new Category(categoryEnum, materialEnum);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ClothingEnum getClothing() {
        return clothing;
    }

    public void setClothing(ClothingEnum clothing) {
        this.clothing = clothing;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
