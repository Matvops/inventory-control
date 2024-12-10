package com.cadenassi.inventory_control.proxy.product;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.proxy.GenericServiceProxy;
import com.cadenassi.inventory_control.services.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceProxy extends GenericServiceProxy implements ProductService {


    private static final Logger log = LoggerFactory.getLogger(ProductServiceProxy.class);

    @Autowired
    private ProductService service;

    public ProductServiceProxy(ProductService service) {
        this.service = service;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("Get all products in proxy");
        return service.getAllProducts();
    }

    @Override
    public ProductDTO getProductById(String id) {
        log.info("Apply validation of the get ProductByIdMethod on the id {}", id);
        verifyIsNull(id);
        verifyIsNumber(id);

        return service.getProductById(id);
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        log.info("Apply validation of the getProductByName method on the name {}", name);
        verifyIsNull(name);

        return service.getProductByName(name);
    }

    @Override
    public <T, R> List<ProductDTO> getProductByCategory(T category, R material) {
        log.info("Apply validation of the getProductByCategory method on the category {} and material {}",
                category, material);

        if (category.toString().isBlank() && material.toString().isBlank())
            verifyIsNull(null);

        var categoryString = category.toString().toUpperCase();
        var materialString = material.toString().toUpperCase();

        var containCat = Arrays.toString(CategoryEnum.values()).contains(categoryString);
        var containMat = Arrays.toString(MaterialEnum.values()).contains(materialString);

        if(!(containCat || containMat))
            throw new ResourceNotFoundException(categoryString + " AND " + materialString + " NO EXISTS!");

        return service.getProductByCategory(categoryString, materialString);
    }


    @Override
    public <T> List<ProductDTO> getProductByClothing(T clothing) {
        log.info("Apply validation of the getProductByClothing method on the clothing {}", clothing);
        verifyIsNull(clothing);

        return service.getProductByClothing(clothing);
    }

    @Override
    public ProductDTO update(String id, ProductDTO product) {
        log.info("Apply validation of the update method on the product {} and id {}", product, id);
        verifyIsNull(id);
        verifyIsNumber(id);
        verifyIsNull(product);

        return service.update(id, product);
    }
}