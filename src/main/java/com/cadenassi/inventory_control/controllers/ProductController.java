package com.cadenassi.inventory_control.controllers;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.enums.CategoryEnum;
import com.cadenassi.inventory_control.enums.MaterialEnum;
import com.cadenassi.inventory_control.proxy.product.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/v1")
public class ProductController {

    @Autowired
    private ProductServiceProxy service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductDTO>> getAll(){
        var products = service.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") String id){
        var product = service.getProductById(id);

        return ResponseEntity.ok().body(product);
    }


    @GetMapping(params = "name",
            produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductDTO>> getProductByName(@RequestParam(value = "name") String name){
        var products = service.getProductByName(name);

        return ResponseEntity.ok().body(products);
    }


    @GetMapping(params = {"category", "material"},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductDTO>> getProductByCategoryAndMaterial(
            @RequestParam(name = "category", defaultValue = "", required = false) String category,
            @RequestParam(name = "material", defaultValue = "", required = false) String material){

        var products = service.getProductByCategory(category, material);

        return ResponseEntity.ok().body(products);
    }


    @GetMapping(params = "brand", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductDTO>> getByBrand(@RequestParam(value = "brand", required = false) String brand){
        var products = service.getProductByBrand(brand);

        return ResponseEntity.ok().body(products);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id, @RequestBody ProductDTO dto){
        var product = service.update(id, dto);

        return ResponseEntity.ok().body(product);
    }
}
