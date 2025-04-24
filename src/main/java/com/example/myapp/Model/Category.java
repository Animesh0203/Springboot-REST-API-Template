package com.example.myapp.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories") // optional, defaults to class name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
