package com.cadenassi.inventory_control.unittests.mocks;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.model.product.Product;

import java.util.List;

public class MockProductSingleton {
    private MockProduct mock;
    private List<Product> products;
    private List<ProductDTO> dtos;
    private final static MockProductSingleton INSTANCE = new MockProductSingleton();

    private MockProductSingleton() {
        mock = new MockProduct();
        products = mock.getListProduct();
        dtos = mock.getListProductDTO();
    }

    public static MockProductSingleton getInstance(){
        return INSTANCE;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<ProductDTO> getDtos() {
        return dtos;
    }
}
