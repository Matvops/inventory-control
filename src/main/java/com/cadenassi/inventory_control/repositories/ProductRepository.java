package com.cadenassi.inventory_control.repositories;

import com.cadenassi.inventory_control.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Procedure(name = "getFilteredProduct")
    List<Product> getProductByFilter(@Param("field_filter") String field, @Param("filter_value")String value);
}
