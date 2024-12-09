package com.cadenassi.inventory_control.services.product;

import com.cadenassi.inventory_control.dto.mappers.ProductMapper;
import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.ClothingEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDTO> getAllProducts(){
        log.info("Get products from repository");
        var products = mapper.toListProductDTO(repository.findAll());


        return products;
    }

    @Override
    public ProductDTO getProductById(String id){
        log.info("Get product from repository by id {}", id);
        var product = mapper.toProductDTO(repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("ID not found!")));

        return product;
    }

    @Override
    public List<ProductDTO> getProductByName(String name){
        log.info("Get product from repository by name {}", name);
        var product = mapper.toListProductDTO(repository.getProductByFilter("NAME", name));


        return product;
    }


    @Override
    public List<ProductDTO> getProductByCategory(CategoryEnum category, MaterialEnum material){
        log.info("Get product from repository by category{} and material {}", category, material);
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
        log.info("Get product from repository by clothing {}", clothing);
        var products = mapper.toListProductDTO(repository.getProductByFilter("CLOTHING", clothing.toString()));

        return products;
    }

    @Override
    public ProductDTO update(String id, ProductDTO product){
        log.info("Update product by id {}", id);
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