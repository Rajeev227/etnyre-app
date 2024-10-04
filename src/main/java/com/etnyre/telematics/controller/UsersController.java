package com.etnyre.telematics.controller;

import com.etnyre.telematics.entity.Users;
import com.etnyre.telematics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public Users saveUsers(@RequestBody Users users) {
        return userRepository.save(users);
    }

    @GetMapping("/users/{id}")
    public Users getUsers(@PathVariable("id") String userId) {
        return userRepository.getUsersById(userId);
    }

    @DeleteMapping("/users/{id}")
    public String deleteEmployee(@PathVariable("id") String userId) {
        return  userRepository.delete(userId);
    }

    @PutMapping("/user/{id}")
    public String updateEmployee(@PathVariable("id") String userId, @RequestBody Users users) {
        return userRepository.update(userId,users);
    }

    @GetMapping("/users")
    public List<Users> getUserss( ) {
        return userRepository.getUsers();
    }

    @GetMapping("/data")
    public String getData() {
        return "Hello Etnyre Users";
    }
    @GetMapping("/message")
    public String getMessage() {
        return "Second message from AWS Ecs";
    }
}
