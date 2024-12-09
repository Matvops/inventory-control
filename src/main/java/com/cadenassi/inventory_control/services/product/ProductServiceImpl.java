package com.cadenassi.inventory_control.services.product;

import com.cadenassi.inventory_control.dto.mappers.ProductMapper;
import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.model.product.Category;
import com.cadenassi.inventory_control.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAllProducts(){
        var products = mapper.toListProductDTO(repository.findAll());

        return products;
    }

    @Override
    public ProductDTO getProductById(String id){
        var product = mapper.toProductDTO(repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("ID not found!")));

        return product;
    }

    @Override
    public List<ProductDTO> getProductByName(String name){
        var product = mapper.toListProductDTO(repository.getProductByFilter("NAME", name));


        return product;
    }


    @Override
    public List<ProductDTO> getProductByCategory(CategoryEnum category, MaterialEnum material){
        List<ProductDTO> products = null;

        if(category != null && material != null){
            products = mapper
                    .toListProductDTO(repository
                            .getFilteredProductByCategory(category, material));

            return products;
        }

        if(category != null) {
            products = mapper.toListProductDTO(repository
                    .getProductByFilter("CATEGORY", category.toString()));
        }

        if(material != null){
             products = mapper.toListProductDTO(repository
                    .getProductByFilter("MATERIAL", material.toString()));
        }


        return products;
    }

    @Override
    public List<ProductDTO> getProductByClothing(ClothingEnum clothing){
        var products = mapper.toListProductDTO(repository.getProductByFilter("CLOTHING", clothing.toString()));

        return products;
    }

    @Override
    public ProductDTO update(String id, ProductDTO product){
        var originalProduct = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("ID not found!"));

        originalProduct.setName(product.getName());
        originalProduct.setCategory(product.getCategory());
        originalProduct.setClothing(product.getClothing());
        originalProduct.setQuantity(product.getQuantity());
        originalProduct.setPrice(product.getPrice());

        repository.save(originalProduct);
        return mapper.toProductDTO(originalProduct);
    }
}