package com.cadenassi.inventory_control.model.product;

import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.model.transactions.purchase.PurchaseItem;
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

    private ClothingEnum clothing;

    @Embedded
    private Category category;

    @OneToMany(mappedBy = "id.product")
    private Set<PurchaseItem> items = new HashSet<>();

    public Product() {}

    public Product(String name, Integer quantity, Float price, ClothingEnum clothing, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.clothing = clothing;
        this.category = category;
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
    public Set<PurchaseItem> getItems() {
        return items;
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
