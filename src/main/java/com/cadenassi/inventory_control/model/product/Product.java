package com.cadenassi.inventory_control.model.product;

import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.model.transactions.purchase.PurchaseItem;
import com.cadenassi.inventory_control.model.transactions.sale.SaleItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Float price;

    @Enumerated(EnumType.STRING)
    private ClothingEnum clothing;

    @Embedded
    private Category category = new Category();

    @OneToMany(mappedBy = "id.product")
    private Set<PurchaseItem> itemsPurchase = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<SaleItem> itemsSale = new HashSet<>();

    public Product() {}

    public Product(String name, Integer quantity, Float price, ClothingEnum clothing,
                   CategoryEnum category, MaterialEnum material) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.clothing = clothing;
        setCategoryEnum(category);
        setMaterialEnum(material);
    }

    public CategoryEnum getCategoryEnum() {
        return category.getCategory();
    }

    public MaterialEnum getMaterialEnum() {
        return category.getMaterial();
    }

    public void setCategoryEnum(CategoryEnum category) {
        this.category.setCategory(category);
    }

    public void setMaterialEnum(MaterialEnum material) {
        this.category.setMaterial(material);
    }

    public Long getId() {
        return id;
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

    @JsonIgnore
    public Set<PurchaseItem> getItemsPurchase() {
        return itemsPurchase;
    }

    @JsonIgnore
    public Set<SaleItem> getItemsSale() {
        return itemsSale;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
