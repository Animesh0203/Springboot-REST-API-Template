package com.example.myapp.Service;

import com.example.myapp.Repository.UserRepo;
import java.util.List;
import com.example.myapp.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo UserRepo;

    public List<User> getAllUsers() {
        return UserRepo.findAll();
    }

    public User createUser(User user) {
        return UserRepo.save(user);
    }   

    public User getUserById(Long id) {
        return UserRepo.findById(id).orElse(null);
    }
    public User updateUser(Long id, User user) {
        if (UserRepo.existsById(id)) {
            user.setId(id);
            return UserRepo.save(user);
        } else {
            return null;
        }
    }
}
