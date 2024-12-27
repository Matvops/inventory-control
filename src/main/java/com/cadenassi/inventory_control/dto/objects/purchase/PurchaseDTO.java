package com.cadenassi.inventory_control.dto.objects.purchase;

import com.cadenassi.inventory_control.dto.objects.product.ProductDTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

public class PurchaseDTO implements Serializable {

    private Long id;

    private float price;

    private String description;

    private Instant created;

    private Instant lastUpdate;

    private final List<ProductDTO> products = new ArrayList<>();

    public PurchaseDTO() {}

    public void total(){
        products.forEach(x -> this.price += x.getPrice() * x.getQuantity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseDTO that = (PurchaseDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
