package com.cadenassi.inventory_control.model.product;

import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.BrandEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.model.transactions.purchase.Purchase;
import com.cadenassi.inventory_control.model.transactions.sale.SaleItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
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
    private Instant created;

    @Column(name = "last_update")
    private Instant lastUpdate;

    @Enumerated(EnumType.STRING)
    private BrandEnum brand;

    @Embedded
    private Category category = new Category();

    @ManyToMany(mappedBy = "products")
    private Set<Purchase> purchases = new HashSet<>();

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
        this.created = Instant.now();
        this.lastUpdate = Instant.now();
    }

    @PreUpdate
    private void onUpdate(){
        this.lastUpdate = Instant.now();
    }

    public CategoryEnum getCategoryEnum() {
        return category.getCategory();
    }

    public MaterialEnum getMaterialEnum() {
        return category.getMaterial();
    }

    public void setCategoryEnum(CategoryEnum category) {
        if(category != null){
            this.category.setCategory(category);
        }
    }

    public void setMaterialEnum(MaterialEnum material) {
        if(material != null) {
            this.category.setMaterial(material);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if(quantity != null){
            this.quantity = quantity;
        }
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        if(price != null){
            this.price = price;
        }
    }

    public BrandEnum getBrand() {
        return brand;
    }

    public void setBrand(BrandEnum brand) {
        if(brand != null){
            this.brand = brand;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if(category != null){
            this.category = category;
        }
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @JsonIgnore
    public Set<Purchase> getPurchases() {
        return purchases;
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
