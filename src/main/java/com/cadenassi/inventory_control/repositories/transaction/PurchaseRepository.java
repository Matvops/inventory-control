package com.cadenassi.inventory_control.repositories.transaction;

import com.cadenassi.inventory_control.model.transactions.purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Procedure(procedureName = "get_purchase_by_date")
    List<Purchase> getPurchaseByDate(@Param("date") String date);


}
