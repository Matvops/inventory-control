package com.cadenassi.inventory_control.proxy.product;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.model.product.Category;
import com.cadenassi.inventory_control.proxy.GenericServiceProxy;
import com.cadenassi.inventory_control.services.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceProxy extends GenericServiceProxy implements ProductService {
    private ProductService service;

    public ProductServiceProxy(ProductService service){
        this.service = service;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return service.getAllProducts();
    }

    @Override
    public ProductDTO getProductById(String id) {
        verifyIsNull(id);
        verifyIsNumber(id);

        return service.getProductById(id);
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        verifyIsNull(name);

        return service.getProductByName(name);
    }

    @Override
    public List<ProductDTO> getProductByCategory(CategoryEnum category, MaterialEnum material) {
        verifyIsNull(category);
        if(category == null && material == null)
            verifyIsNull(null);


        return service.getProductByCategory(category, material);
    }

    @Override
    public List<ProductDTO> getProductByClothing(ClothingEnum clothing) {
        verifyIsNull(clothing);

        return service.getProductByClothing(clothing);
    }

    @Override
    public ProductDTO update(String id, ProductDTO product) {
        verifyIsNull(id);
        verifyIsNumber(id);
        verifyIsNull(product);

        return service.update(id, product);
    }
}