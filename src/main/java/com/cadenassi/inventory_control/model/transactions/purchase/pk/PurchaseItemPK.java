package com.cadenassi.inventory_control.model.transactions.purchase;

import com.cadenassi.inventory_control.model.product.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class PurchaseItemPK {

    @ManyToOne
    private Product productId;

    @EmbeddedId
    @ManyToOne
    private PurchaseVO purchaseId;


    public PurchaseItemPK() {}

    public PurchaseItemPK(Product productId, PurchaseVO purchaseId) {
        this.productId = productId;
        this.purchaseId = purchaseId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public PurchaseVO getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(PurchaseVO purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItemPK that = (PurchaseItemPK) o;
        return Objects.equals(productId, that.productId) && Objects.equals(purchaseId, that.purchaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, purchaseId);
    }
}