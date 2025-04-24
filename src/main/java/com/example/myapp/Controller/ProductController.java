package com.example.myapp.Controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.myapp.Mapper.ProductMapper;
import com.example.myapp.Model.Product;
import com.example.myapp.Repository.ProductRepo;

import lombok.AllArgsConstructor;

import com.example.myapp.DTO.ProductDto;

@AllArgsConstructor
@RestController
public class ProductController {
    
    private final ProductMapper productMapper;

    @Autowired
    private ProductRepo productRepo;

    @RequestMapping("/products")
    public List<ProductDto> getAllProducts(
        @RequestParam(required = false, name = "id") Byte id
    ) {
        List<Product> products;
        if(id != null) {
            products = productRepo.findByCategoryId(id);
        } else {
            products = productRepo.findAll();
        }
        return products
                .stream()
                .map(productMapper::toProductDto)
                .toList();
    }
}
