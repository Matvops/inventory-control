package com.cadenassi.inventory_control.repositories.transaction;

import com.cadenassi.inventory_control.model.transactions.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
