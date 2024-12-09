package com.cadenassi.inventory_control.proxy.product;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.proxy.GenericServiceProxy;
import com.cadenassi.inventory_control.services.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceProxy extends GenericServiceProxy implements ProductService {


    private static final Logger log = LoggerFactory.getLogger(ProductServiceProxy.class);

    @Autowired
    private ProductService service;

    public ProductServiceProxy(ProductService service){
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
    public List<ProductDTO> getProductByCategory(CategoryEnum category, MaterialEnum material) {
        log.info("Apply validation of the getProductByCategory method on the category {} and material {}",
                category, material);
        verifyIsNull(category);
        if(category == null && material == null)
            verifyIsNull(null);


        return service.getProductByCategory(category, material);
    }

    @Override
    public List<ProductDTO> getProductByClothing(ClothingEnum clothing) {
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