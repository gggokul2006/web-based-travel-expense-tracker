package com.example.Web.Based.Travel.Expense.Tracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.AdminEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Create a new Admin
    public AdminEntity createAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    // Get Admin by ID
    public AdminEntity getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    // Update Admin
    public AdminEntity updateAdmin(Long id, AdminEntity adminDetails) {
        AdminEntity admin = getAdminById(id);
        admin.setName(adminDetails.getName());
        admin.setEmail(adminDetails.getEmail());
        admin.setPassword(adminDetails.getPassword());
        admin.setAddress(adminDetails.getAddress());
        return adminRepository.save(admin);
    }

    // Delete Admin
    public void deleteAdmin(Long id) {
        if (!adminRepository.existsById(id)) {  // ✅ Fixed repository call
            throw new RuntimeException("Admin not found with id: " + id);
        }
        adminRepository.deleteById(id);
    }
}
