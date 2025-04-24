package com.example.myapp.DTO;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private Byte categoryId;
}
