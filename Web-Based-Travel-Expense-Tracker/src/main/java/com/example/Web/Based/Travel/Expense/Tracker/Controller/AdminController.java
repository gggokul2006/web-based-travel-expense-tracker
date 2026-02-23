package com.example.Web.Based.Travel.Expense.Tracker.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.AdminEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Service.AdminService;


@RestController
@RequestMapping("/api/admins")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	// Create a new Admin
	@PostMapping
	public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity admin) {
		AdminEntity savedAdmin = adminService.createAdmin(admin);
		return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
	}
	
	// Get Admin by ID
	@GetMapping("/{id}")
	public ResponseEntity<AdminEntity> getAdminById(@PathVariable Long id) {
		AdminEntity admin = adminService.getAdminById(id);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	// Update Admin
	@PutMapping("/{id}")
	public ResponseEntity<AdminEntity> updateAdmin(@PathVariable Long id, @RequestBody AdminEntity admin) {
		AdminEntity updatedAdmin = adminService.updateAdmin(id, admin);
		return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
	}
	
	// Delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	    adminService.deleteAdmin(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
	


