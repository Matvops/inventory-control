package com.cadenassi.inventory_control.repositories;

import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Procedure(name = "get_product_with_a_filter")
    List<Product> getProductByFilter(@Param("field_filter") String field, @Param("filter_value")String value);

    @Procedure(name = "get_product_by_filter_category")
    List<Product> getFilteredProductByCategory(@Param("category") CategoryEnum categoryEnum,
                                               @Param("material") MaterialEnum material);
}
