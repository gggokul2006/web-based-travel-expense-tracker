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

import com.example.Web.Based.Travel.Expense.Tracker.Entity.ReportEntity;

import com.example.Web.Based.Travel.Expense.Tracker.Service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*") // Enable CORS if needed
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<List<ReportEntity>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportEntity> getReportById(@PathVariable Long id) {
        Optional<ReportEntity> report = reportService.getReportById(id);
        return report.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ReportEntity> createReport(@PathVariable Long userId, @RequestBody ReportEntity report) {
        return ResponseEntity.ok(reportService.createReport(report , userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportEntity> updateReport(@PathVariable Long id, @RequestBody ReportEntity updatedReport) {
        return ResponseEntity.ok(reportService.updateReport(id, updatedReport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
       reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
