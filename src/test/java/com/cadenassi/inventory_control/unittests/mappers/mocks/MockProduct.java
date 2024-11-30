package com.cadenassi.inventory_control.unittests.mappers.mocks;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.model.product.Category;
import com.cadenassi.inventory_control.model.product.Product;

import java.util.ArrayList;
import java.util.List;


public class MockProduct {


    public Product getProduct(){
        return getProduct(0);
    }

    public ProductDTO getProductDTO(){
        return getProductDTO(0);
    }

    public Product getProduct(Integer id){
        Product product = new Product();
        product.setName("PRODUCT"+id);
        product.setPrice(10.0f * id);
        product.setQuantity(10 * id);
        product.setClothing(ClothingEnum.getClothing(id));
        product.setCategoryEnum(CategoryEnum.getCategory(id));
        product.setMaterialEnum(MaterialEnum.getMaterial(id));

        return product;
    }

    public ProductDTO getProductDTO(Integer id){
        ProductDTO product = new ProductDTO();
        product.setName("PRODUCT"+id);
        product.setPrice(10.0f * id);
        product.setQuantity(10 * id);
        product.setClothing(ClothingEnum.getClothing(id));
        product.setCategory(new Category(CategoryEnum.getCategory(id), MaterialEnum.getMaterial(id)));

        return product;
    }

    public List<Product> getListProduct(){
        var products = new ArrayList<Product>();
        var product = new Product();

        for (int i = 0; i < 10; i++){
            product.setName("PRODUCT"+i);
            product.setPrice(10.0f * i);
            product.setQuantity(10 * i);
            product.setCategoryEnum(CategoryEnum.getCategory(i));
            product.setMaterialEnum(MaterialEnum.getMaterial(i));
        }

        return products;
    }

    public List<ProductDTO> getListProductDTO(){
        var products = new ArrayList<ProductDTO>();
        var product = new ProductDTO();

        for (int i = 0; i < 10; i++){
            product.setName("PRODUCT"+i);
            product.setPrice(10.0f * i);
            product.setQuantity(10 * i);
            product.setClothing(ClothingEnum.getClothing(i));
            product.setCategory(new Category(CategoryEnum.getCategory(i), MaterialEnum.getMaterial(i)));
        }

        return products;
    }
}
