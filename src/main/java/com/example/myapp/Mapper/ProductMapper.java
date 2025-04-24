package com.example.myapp.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.myapp.DTO.ProductDto;
import com.example.myapp.Model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toProductDto(Product product);
}
