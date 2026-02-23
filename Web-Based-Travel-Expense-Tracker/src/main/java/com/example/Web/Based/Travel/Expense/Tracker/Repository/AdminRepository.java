package com.example.Web.Based.Travel.Expense.Tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Web.Based.Travel.Expense.Tracker.Entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
	

}
