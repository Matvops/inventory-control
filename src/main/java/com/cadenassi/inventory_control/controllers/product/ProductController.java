package com.cadenassi.inventory_control.controllers.product;

import com.cadenassi.inventory_control.dto.objects.product.ProductDTO;
import com.cadenassi.inventory_control.proxy.product.ProductServiceProxy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/v1")
@Tag(name = "Products", description = "Product controller")
public class ProductController {

    @Autowired
    private ProductServiceProxy service;


    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get all products", description = "Method to get all products", tags = {"Products"}, responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                    , array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
    })
    public ResponseEntity<List<ProductDTO>> getAll() {
        var products = service.getAllProducts();
        return ResponseEntity.ok().body(products);
    }


    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get Product by id", description = "Method to get a product by id", tags = {"Products"}
            , responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
    })
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") String id) {
        var product = service.getProductById(id);

        return ResponseEntity.ok().body(product);
    }

    @GetMapping(params = "name", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get Product by name", description = "Method to get a product by name", tags = {"Products"}
            , parameters = {@Parameter(name = "name", description = "name of product")}
            , responses =
            {
                    @ApiResponse(responseCode = "200", description = "SUCCESS"
                            , content = @Content(schema = @Schema(implementation = ProductDTO.class))),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
                    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
            }
    )
    public ResponseEntity<List<ProductDTO>> getProductByName(@RequestParam(value = "name") String name) {
        var products = service.getProductByName(name);

        return ResponseEntity.ok().body(products);
    }


    @GetMapping(params = {"category", "material"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get Product by category or material", description = "Method to get a product by category or material"
            , tags = {"Products"}, responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
    })
    public ResponseEntity<List<ProductDTO>> getProductByCategoryAndMaterial(
            @RequestParam(name = "category", defaultValue = "", required = false) String category,
            @RequestParam(name = "material", defaultValue = "", required = false) String material) {

        var products = service.getProductByCategory(category, material);

        return ResponseEntity.ok().body(products);
    }


    @GetMapping(params = "brand", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get Product by brand", description = "Method to get a product by brand"
            , tags = {"Products"}, responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"
                    , content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
    })
    public ResponseEntity<List<ProductDTO>> getByBrand(@RequestParam(value = "brand", required = false) String brand) {
        var products = service.getProductByBrand(brand);

        return ResponseEntity.ok().body(products);
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Update Product by id", description = "Method to update a product by id"
            , tags = {"Products"}, responses = {
            @ApiResponse(responseCode = "200", description = "UPDATED SUCCESSFULLY"
                    , content = @Content(schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content),
            @ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content)
    })
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String id, @RequestBody ProductDTO dto) {
        var product = service.update(id, dto);

        return ResponseEntity.ok().body(product);
    }
}
