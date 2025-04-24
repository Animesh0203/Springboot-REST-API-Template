package com.example.myapp.DTO;

import lombok.Data;

@Data
public class changePassword {
    private String oldPassword;
    private String newPassword;
}
