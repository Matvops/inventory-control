package com.cadenassi.inventory_control.unittests.mappers;

import com.cadenassi.inventory_control.dto.mappers.ProductMapper;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.BrandEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.unittests.mocks.MockProduct;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductMapperTest {

    private MockProduct mock;

    private ProductMapper mapper;

    @BeforeEach
    void setUp() {
        mock = new MockProduct();
        mapper = ProductMapper.INSTANCE;
    }

    @Test
    @Order(0)
    void productToProductDTOTest() {
        var product = mock.getProduct(1);
        var dto = mapper.toProductDTO(product);

        assertEquals("PRODUCT1", dto.getName());
        assertEquals(10, dto.getPrice());
        assertEquals(10, dto.getQuantity());
        assertEquals(BrandEnum.getClothing(1), dto.getBrand());
        assertEquals(CategoryEnum.getCategory(1), dto.getCategory().getCategory());
        assertEquals(MaterialEnum.getMaterial(1), dto.getCategory().getMaterial());
    }

    @Test
    @Order(1)
    void productDTOToProductTest() {
        var dto = mock.getProductDTO(1);
        var product = mapper.toProduct(dto);

        assertEquals("PRODUCT1", product.getName());
        assertEquals(10, product.getPrice());
        assertEquals(10, product.getQuantity());
        assertEquals(BrandEnum.getClothing(1), product.getBrand());
        assertEquals(CategoryEnum.getCategory(1), product.getCategory().getCategory());
        assertEquals(MaterialEnum.getMaterial(1), product.getCategory().getMaterial());
    }

    @Test
    @Order(2)
    void listProductToListProductDTOTest() {
        var products = mock.getListProduct();
        var dtos = mapper.toListProductDTO(products);

        for(int i = 0; i < dtos.size(); i++){
            assertEquals("PRODUCT"+i, dtos.get(i).getName());
            assertEquals(10 * i, dtos.get(i).getPrice());
            assertEquals(10 * i, dtos.get(i).getQuantity());
            assertEquals(BrandEnum.getClothing(i), dtos.get(i).getBrand());
            assertEquals(CategoryEnum.getCategory(i), dtos.get(i).getCategory().getCategory());
            assertEquals(MaterialEnum.getMaterial(i), dtos.get(i).getCategory().getMaterial());
        }
    }

    @Test
    @Order(3)
    void listProductDTOToListProductTest() {
        var dtos = mock.getListProductDTO();
        var products = mapper.toListProduct(dtos);

        for(int i = 0; i < dtos.size(); i++){
            assertEquals("PRODUCT"+i, products.get(i).getName());
            assertEquals(10 * i, products.get(i).getPrice());
            assertEquals(10 * i, products.get(i).getQuantity());
            assertEquals(BrandEnum.getClothing(i), products.get(i).getBrand());
            assertEquals(CategoryEnum.getCategory(i), products.get(i).getCategory().getCategory());
            assertEquals(MaterialEnum.getMaterial(i), products.get(i).getCategory().getMaterial());
        }
    }
}
