package com.cadenassi.inventory_control.model.product;

import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.BrandEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.model.transactions.purchase.PurchaseItem;
import com.cadenassi.inventory_control.model.transactions.sale.SaleItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "product")
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

    @Column
    private Date created;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Enumerated(EnumType.STRING)
    private BrandEnum brand;

    @Embedded
    private Category category = new Category();

    @OneToMany(mappedBy = "id.product")
    private Set<PurchaseItem> itemsPurchase = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<SaleItem> itemsSale = new HashSet<>();

    public Product() {}

    public Product(String name, Integer quantity, Float price, BrandEnum brand,
                   CategoryEnum category, MaterialEnum material) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.brand = brand;
        setCategoryEnum(category);
        setMaterialEnum(material);
    }

    @PrePersist
    private void onCreate(){
        this.created = new Date();
        this.lastUpdate = new Date();
    }

    @PreUpdate
    private void onUpdate(){
        this.lastUpdate = new Date();
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

    public BrandEnum getBrand() {
        return brand;
    }

    public void setBrand(BrandEnum brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
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
