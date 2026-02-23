package com.example.Web.Based.Travel.Expense.Tracker.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "expenses")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Correct primary key
    private Long id; // Change from 'reportId' to 'id'

    private Double amount;
    private String category;
    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
