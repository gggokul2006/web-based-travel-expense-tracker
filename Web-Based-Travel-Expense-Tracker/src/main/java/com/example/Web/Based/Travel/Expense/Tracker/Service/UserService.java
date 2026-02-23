package com.example.Web.Based.Travel.Expense.Tracker.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.UserEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public UserEntity getUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Update user
    public UserEntity updateUser(Long id, UserEntity userDetails) {
        UserEntity user = getUserById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setAddress(userDetails.getAddress());
        return userRepository.save(user);
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
