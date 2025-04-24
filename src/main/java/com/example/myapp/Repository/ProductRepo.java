package com.example.myapp.Repository;

import org.springframework.stereotype.Repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myapp.Model.User;
import com.example.myapp.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    // Custom query methods can be defined here if needed
    List<Product> findByCategoryId(Byte categoryId);
}
