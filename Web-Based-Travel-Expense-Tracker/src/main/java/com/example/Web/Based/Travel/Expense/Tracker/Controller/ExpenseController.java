package com.example.Web.Based.Travel.Expense.Tracker.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.ExpenseEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*") // Enable CORS if needed
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseEntity>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        Optional<ExpenseEntity> expense = expenseService.getExpenseById(id);
        return expense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ExpenseEntity> createExpense(@PathVariable Long userId, @RequestBody ExpenseEntity expense) {
        return ResponseEntity.ok(expenseService.createExpense(expense, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseEntity> updateExpense(@PathVariable Long id, @RequestBody ExpenseEntity updatedExpense) {
        return ResponseEntity.ok(expenseService.updateExpense(id, updatedExpense));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
