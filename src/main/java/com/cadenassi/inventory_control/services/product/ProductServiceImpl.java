package com.cadenassi.inventory_control.services.product;

import com.cadenassi.inventory_control.dto.mappers.ProductMapper;
import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import com.cadenassi.inventory_control.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    @Transactional
    @Override
    public List<ProductDTO> getAllProducts(){
        log.info("Get products from repository");
        var products = mapper.toListProductDTO(repository.findAll());


        return products;
    }

    @Transactional
    @Override
    public ProductDTO getProductById(String id){
        log.info("Get product from repository by id {}", id);
        var product = mapper.toProductDTO(repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("ID not found!")));

        return product;
    }

    @Transactional
    @Override
    public List<ProductDTO> getProductByName(String name){
        log.info("Get product from repository by name {}", name);
        var product = mapper.toListProductDTO(repository.getProductByFilter("NAME", name));


        return product;
    }

    @Transactional
    @Override
    public <T, R> List<ProductDTO> getProductByCategory(T category, R material) {
        log.info("Get product from repository by category {} and material {}", category, material);
        List<ProductDTO> products = null;

        var categoryBool = category.toString().isBlank();
        var materialBool = material.toString().isBlank();

        if((!categoryBool) && (!materialBool)){
            products = mapper
                    .toListProductDTO(repository
                            .getFilteredProductByCategory(category.toString().toUpperCase(), material.toString().toUpperCase()));

            return products;
        }

        if(!categoryBool) {
            products = mapper.toListProductDTO(repository
                    .getProductByFilter("CATEGORY", category.toString().toUpperCase()));
        }

        if(!materialBool){
            products = mapper.toListProductDTO(repository
                    .getProductByFilter("MATERIAL", material.toString().toUpperCase()));
        }


        return products;
    }


    @Transactional
    @Override
    public <T> List<ProductDTO> getProductByBrand(T brand){
        log.info("Get product from repository by brand {}", brand);
        var products = mapper.toListProductDTO(repository.getProductByFilter("BRAND", brand.toString()));

        return products;
    }

    @Override
    public ProductDTO update(String id, ProductDTO product){
        log.info("Update product by id {}", id);
        var originalProduct = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("ID not found!"));

        originalProduct.setName(product.getName());
        originalProduct.setCategory(product.getCategory());
        originalProduct.setBrand(product.getBrand());
        originalProduct.setQuantity(product.getQuantity());
        originalProduct.setPrice(product.getPrice());

        repository.save(originalProduct);
        return mapper.toProductDTO(originalProduct);
    }
}