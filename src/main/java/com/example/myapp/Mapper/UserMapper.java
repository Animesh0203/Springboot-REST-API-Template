package com.example.myapp.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.myapp.DTO.RegisterUser;
import com.example.myapp.DTO.UserDto;
import com.example.myapp.Model.User;
import com.example.myapp.DTO.UpdateUser;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    User toEntity(RegisterUser registerUser);
    void updateUserFromDto(UpdateUser registerUser, @MappingTarget User user);
}
 