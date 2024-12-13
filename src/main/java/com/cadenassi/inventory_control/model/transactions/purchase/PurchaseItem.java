package com.cadenassi.inventory_control.model.transactions.purchase;

import com.cadenassi.inventory_control.model.product.Product;
import com.cadenassi.inventory_control.model.transactions.purchase.pk.PurchaseItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "purchase_product")
public class PurchaseItem implements Serializable {

    @EmbeddedId
    private PurchaseItemPK id = new PurchaseItemPK();

    private int quantity;

    private float price;

    public PurchaseItem() {}

    public PurchaseItem(Product product, Purchase purchase, float price, int quantity) {
        setProduct(product);
        setPurchase(purchase);
        this.price = price;
        this.quantity = quantity;
    }

    public Float subTotal(){
        return (Float) price * quantity;
    }

    public Product getProduct() {
        return this.id.getProduct();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }

    public Purchase getPurchase() {
        return this.id.getPurchase();
    }

    public void setPurchase(Purchase purchase) {
        this.id.setPurchase(purchase);
    }

    public PurchaseItemPK getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItem that = (PurchaseItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
