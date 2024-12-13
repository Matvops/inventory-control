package com.cadenassi.inventory_control.model.transactions.sale;

import com.cadenassi.inventory_control.model.product.Product;
import com.cadenassi.inventory_control.model.transactions.sale.pk.SaleItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sale_product")
public class SaleItem implements Serializable {

    @EmbeddedId
    private SaleItemPK id = new SaleItemPK();

    @Column(nullable = false)
    private float price;

    @Column(nullable = true)
    private int quantity;

    public SaleItem(Sale sale, Product product, float price, int quantity) {
        setSale(sale);
        setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    protected float subTotal(){
        return (Float) price * quantity;
    }

    public Product getProduct() {
        return this.id.getProduct();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }

    @JsonIgnore
    public Sale getSale() {
        return this.id.getSale();
    }

    public void setSale(Sale sale) {
        this.id.setSale(sale);
    }


    public SaleItemPK getId() {
        return id;
    }

    public void setId(SaleItemPK id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SaleItem saleItem = (SaleItem) o;
        return Objects.equals(id, saleItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
