package com.example.myapp.DTO;

import lombok.Getter;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String email;
}
