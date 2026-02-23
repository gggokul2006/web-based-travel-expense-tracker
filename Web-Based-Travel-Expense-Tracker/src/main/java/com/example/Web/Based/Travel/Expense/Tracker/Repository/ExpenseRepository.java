package com.example.Web.Based.Travel.Expense.Tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

}
