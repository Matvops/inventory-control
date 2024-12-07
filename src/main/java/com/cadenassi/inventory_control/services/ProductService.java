package com.cadenassi.inventory_control.services;

import com.cadenassi.inventory_control.dto.mappers.ProductMapper;
import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.model.product.Category;
import com.cadenassi.inventory_control.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    public List<ProductDTO> getAllProducts(){
        var products = mapper.toListProductDTO(repository.findAll());

        return products;
    }

    public ProductDTO getProductById(Long id){
        var product = mapper.toProductDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ERROR GET BY ID")));

        return product;
    }

    public List<ProductDTO> getProductByName(String name){
        var product = mapper.toListProductDTO(repository.getProductByFilter("NAME", name));


        return product;
    }

    public List<ProductDTO> getProductByCategory(Category category){
        var products = mapper.toListProductDTO(repository.getProductByFilter("CATEGORY", category.toString()));

        return products;
    }

    public List<ProductDTO> getProductByClothing(ClothingEnum clothing){
        var products = mapper.toListProductDTO(repository.getProductByFilter("CLOTHING", clothing.toString()));

        return products;
    }

    public ProductDTO update(Long id, ProductDTO product){
        var dto = mapper.toProductDTO(repository.findById(id).orElseThrow(() -> new RuntimeException("error1")));

        dto.setName(product.getName());
        dto.setCategory(product.getCategory());
        dto.setClothing(product.getClothing());
        dto.setQuantity(product.getQuantity());
        dto.setPrice(product.getPrice());

        repository.save(mapper.toProduct(dto));
        return dto;
    }
}