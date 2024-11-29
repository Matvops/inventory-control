package com.cadenassi.inventory_control.model.transactions.purchase.pk;

import com.cadenassi.inventory_control.model.product.Product;
import com.cadenassi.inventory_control.model.transactions.purchase.Purchase;
import com.cadenassi.inventory_control.model.transactions.purchase.PurchaseItem;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name ="purchase_id")
    private Purchase purchase;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItemPK that = (PurchaseItemPK) o;
        return Objects.equals(product, that.product) && Objects.equals(purchase, that.purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, purchase);
    }
}