package com.example.Web.Based.Travel.Expense.Tracker.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.ManagerEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    // Create a new expense
    @PostMapping("/{id}")
    public ResponseEntity<ManagerEntity> createManager(@RequestBody ManagerEntity manager) {
        return new ResponseEntity<>(managerService.createManager(manager), HttpStatus.CREATED);
    }

    // Get all expenses
    @GetMapping
    public ResponseEntity<List<ManagerEntity>> getAllManagers() {
        return new ResponseEntity<>(managerService.getAllManagers(), HttpStatus.OK);
    }

    // Get expense by ID
    @GetMapping("/{id}")
    public ResponseEntity<ManagerEntity> getManagerById(@PathVariable Long id) {
        return new ResponseEntity<>(managerService.getManagerById(id), HttpStatus.OK);
    }


    // Update expense
    @PutMapping("/{id}")
    public ResponseEntity<ManagerEntity> updateManager(@PathVariable Long id, @RequestBody ManagerEntity managerDetails) {
        return new ResponseEntity<>(managerService.updateManager(id, managerDetails), HttpStatus.OK);
    }

    // Delete expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
