package com.cadenassi.inventory_control.services.product;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(String  id);
    List<ProductDTO> getProductByName(String name);
    <T, R> List<ProductDTO> getProductByCategory(T category, R material);
    <T> List<ProductDTO> getProductByBrand(T brand);
    ProductDTO update(String  id, ProductDTO product);
}
