package com.example.myapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.logging.Filter;

import com.example.myapp.DTO.UserDto;
import com.example.myapp.DTO.changePassword;
import com.example.myapp.DTO.ProductDto;
import com.example.myapp.Entities.Message;
import com.example.myapp.Model.User;
import com.example.myapp.Repository.UserRepo;
import com.example.myapp.Repository.ProductRepo;
import com.example.myapp.Service.UserService;
import com.example.myapp.DTO.RegisterUser;
import com.example.myapp.DTO.UpdateUser;

import com.example.myapp.Mapper.*;

import lombok.AllArgsConstructor;
import lombok.experimental.var;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final ProductMapper productMapper;

    @Autowired
    private UserService userService;
    private UserRepo userRepo;
    private ProductRepo productRepo;

    @GetMapping("/")
    public Message index() {
        return new Message("Hello World!");
    }

    @RequestMapping("/users")
    public Iterable<UserDto> getAllUsers(
            @RequestParam(required = false, defaultValue = "id") String sort) {
        return userRepo.findAll(Sort.by(sort).descending())
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    @RequestMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        var user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userMapper.toUserDto(user));
        }
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUser registerUser,
            UriComponentsBuilder uriBuilder) {

        var user = userMapper.toEntity(registerUser);
        userRepo.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(userMapper.toUserDto(user));
    }

    @PutMapping("users/{id}")
    public ResponseEntity<UserDto> putMethodName(@PathVariable(name = "id") Long id, @RequestBody UpdateUser entity) {
        var user = userRepo.findById(id).orElse(null);
        if (user != null) {
            userMapper.updateUserFromDto(entity, user);
            userRepo.save(user);
            return ResponseEntity.ok(userMapper.toUserDto(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        var user = userRepo.findById(id).orElse(null);
        if (user != null) {
            userRepo.delete(user);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("users/{id}/change-password")
    public ResponseEntity<Void> changePassword(@RequestBody changePassword password, @PathVariable Long id) {
        // TODO: process POST request
        var user = userRepo.findById(id).orElse(null);
        if (user != null) {
            if (user.getPassword().equals(password.getOldPassword())) {
                user.setPassword(password.getNewPassword());
                userRepo.save(user);
                return ResponseEntity.ok().build();
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
