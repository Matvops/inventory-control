package com.cadenassi.inventory_control.repositories.transaction;

import com.cadenassi.inventory_control.model.transactions.purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
