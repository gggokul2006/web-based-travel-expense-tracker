package com.example.Web.Based.Travel.Expense.Tracker.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.ManagerEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Repository.ManagerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    // Create a new notification
    public ManagerEntity createManager(ManagerEntity manager) {
        return managerRepository.save(manager);
    }

    // Get all notifications
    public List<ManagerEntity> getAllManagers() {
        return managerRepository.findAll();
    }

    // Get notification by ID
    public ManagerEntity getManagerById(Long id) {
        Optional<ManagerEntity> manager = managerRepository.findById(id);
        return manager.orElseThrow(() -> new RuntimeException("Manager not found with id: " + id));
    }

    // Update an existing notification
    public ManagerEntity updateManager(Long id, ManagerEntity managerDetails) {
        ManagerEntity manager = getManagerById(id);
        manager.setName(managerDetails.getName());
        manager.setEmail(managerDetails.getEmail());
        manager.setPassword(managerDetails.getPassword());
        manager.setAddress(managerDetails.getAddress());
        return managerRepository.save(manager);
    }

    // Delete an notification
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }
}
