package com.example.myapp.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // This is the primary key

    private String name;
    private String description;
    private Long price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id") // FK to Category
    private Category category;
}
