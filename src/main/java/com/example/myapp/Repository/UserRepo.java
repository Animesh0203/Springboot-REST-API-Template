package com.example.myapp.Repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myapp.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
   // Custom query methods can be defined here if needed

}