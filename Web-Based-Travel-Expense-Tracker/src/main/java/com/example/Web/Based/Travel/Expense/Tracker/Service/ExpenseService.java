package com.example.Web.Based.Travel.Expense.Tracker.Service;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.ExpenseEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Repository.ExpenseRepository;
import com.example.Web.Based.Travel.Expense.Tracker.Entity.UserEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public List<ExpenseEntity> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<ExpenseEntity> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public ExpenseEntity createExpense(ExpenseEntity expense, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    public ExpenseEntity updateExpense(Long id, ExpenseEntity updatedExpense) {
        return expenseRepository.findById(id)
                .map(expense -> {
                    expense.setDescription(updatedExpense.getDescription());
                    expense.setAmount(updatedExpense.getAmount());
                    expense.setDate(updatedExpense.getDate());
                    expense.setCategory(updatedExpense.getCategory());
                    return expenseRepository.save(expense);
                })
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
