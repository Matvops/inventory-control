package com.cadenassi.inventory_control.services.product;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.model.product.Category;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(String  id);
    List<ProductDTO> getProductByName(String name);
    List<ProductDTO> getProductByCategory(Category category);
    List<ProductDTO> getProductByClothing(ClothingEnum clothing);
    ProductDTO update(String  id, ProductDTO product);
}
