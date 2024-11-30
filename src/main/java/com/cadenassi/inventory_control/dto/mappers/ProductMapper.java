package com.cadenassi.inventory_control.dto.mappers;

import com.cadenassi.inventory_control.dto.objects.ProductDTO;
import com.cadenassi.inventory_control.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);

    List<Product> toListProduct(List<ProductDTO> productDTOList);

    List<ProductDTO> toListProductDTO(List<Product> productList);
}
