package com.cadenassi.inventory_control.unittests.services;

import com.cadenassi.inventory_control.dto.mappers.ProductMapper;
import com.cadenassi.inventory_control.dto.objects.product.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.BrandEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.repositories.ProductRepository;
import com.cadenassi.inventory_control.services.product.ProductServiceImpl;
import com.cadenassi.inventory_control.unittests.mocks.product.MockProductSingleton;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest {

    @Mock
    ProductMapper mapper;

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductServiceImpl service;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(0)
    void getAllTest(){
        //ARRANGE
        var products = MockProductSingleton.getInstance().getProducts();
        var dtos = MockProductSingleton.getInstance().getDtos();

        when(repository.findAll()).thenReturn(products);
        when(mapper.toListProductDTO(products)).thenReturn(dtos);

        //ACT
        List<ProductDTO> result = service.getAllProducts();

        //ASSERTIONS

        for(int i = 0; i < products.size(); i++){
            assertEquals(result.get(i).getName(), dtos.get(i).getName());
            assertEquals(result.get(i).getQuantity(), dtos.get(i).getQuantity());
            assertEquals(result.get(i).getPrice(), dtos.get(i).getPrice());
            assertEquals(result.get(i).getBrand(), dtos.get(i).getBrand());
        }

        verify(repository, times(1)).findAll();
    }

    @Test
    @Order(1)
    void getProductByIdTest(){
        //ARRANGE
        var products = MockProductSingleton.getInstance().getProducts();
        var dtos = MockProductSingleton.getInstance().getDtos();

        when(repository.findById(1L)).thenReturn(Optional.of(products.get(1)));
        when(mapper.toProductDTO(products.get(1))).thenReturn(dtos.get(1));

        //ACT
        service.getProductById("1");

        //ASSERTIONS
        verify(repository, times(1)).findById(1L);
        verify(mapper, times(1)).toProductDTO(eq(products.get(1)));
    }

    @Test
    @Order(2)
    void getProductByNameTest(){
        //ARRANGE
        var products = MockProductSingleton.getInstance()
                .getProducts()
                .stream()
                .filter(x -> "PRODUCT1".equals(x.getName()))
                .toList();


        var dtos = MockProductSingleton.getInstance()
                .getDtos()
                .stream()
                .filter(x -> "PRODUCT1".equals(x.getName()))
                .toList();

        when(repository.getProductByFilter("NAME", "PRODUCT1")).thenReturn(products);
        when(mapper.toListProductDTO(products)).thenReturn(dtos);

        //ACT
        service.getProductByName("PRODUCT1");

        //ASSERTIONS
        verify(repository, times(1))
                .getProductByFilter(eq("NAME"), eq("PRODUCT1"));

        verify(mapper, times(1)).toListProductDTO(eq(products));
    }

    @Test
    @Order(3)
    void getProductByClothingTest(){
        //ARRANGE
        var products = MockProductSingleton.getInstance()
                .getProducts()
                .stream()
                .filter(x -> x.getBrand().equals(BrandEnum.getClothing(0)))
                .toList();


        var dtos = MockProductSingleton.getInstance().getDtos()
                .stream()
                .filter(x -> x.getBrand().equals(BrandEnum.getClothing(0)))
                .toList();

        when(repository.getProductByFilter("BRAND", BrandEnum.getClothing(0).toString()))
                .thenReturn(products);

        when(mapper.toListProductDTO(products)).thenReturn(dtos);


        //ACT
        service.getProductByBrand(BrandEnum.getClothing(0));

        //ASSERTIONS
        verify(repository, times(1))
                .getProductByFilter(eq("BRAND"), eq(BrandEnum.getClothing(0).toString()));

        verify(mapper).toListProductDTO(eq(products));
    }

    @Test
    @Order(4)
    void getProductByCategory(){
        //ARRANGE
        var products = MockProductSingleton.getInstance()
                .getProducts()
                .stream()
                .filter(x -> MaterialEnum.ALGODAO.equals(x.getMaterialEnum())
                        && CategoryEnum.BLUSA.equals(x.getCategoryEnum()))
                .toList();

        var dtos = MockProductSingleton.getInstance()
                .getDtos()
                .stream()
                .filter(x -> MaterialEnum.ALGODAO.equals(x.getCategory().getMaterial())
                        && CategoryEnum.BLUSA.equals(x.getCategory().getCategory()))
                .toList();

        when(repository.getFilteredProductByCategory(CategoryEnum.BLUSA.toString(), MaterialEnum.ALGODAO.toString()))
                .thenReturn(products);
        when(mapper.toListProductDTO(products)).thenReturn(dtos);


        //ACT
        service.getProductByCategory(CategoryEnum.BLUSA, MaterialEnum.ALGODAO);

        //ASSERTIONS
        verify(repository).getFilteredProductByCategory(eq(CategoryEnum.BLUSA.toString()), eq(MaterialEnum.ALGODAO.toString()));
    }

    @Test
    @Order(5)
    void updateTest(){
        //ARRANGE
        var product = MockProductSingleton.getInstance().getProducts().getFirst();
        var dto = MockProductSingleton.getInstance().getDtos().getLast();

        when(repository.findById(0L)).thenReturn(Optional.of(product));
        when(repository.save(product)).thenReturn(product);
        when(mapper.toProductDTO(product)).thenReturn(dto);

        //ACT
        service.update("0", dto);

        //ASSERTIONS
        verify(repository, times(1)).findById(eq(0L));
        verify(repository, times(1)).save(eq(product));
        verify(mapper, times(1))
                .toProductDTO(argThat(x -> "PRODUCT9".equals(x.getName())));
    }
}
