package com.example.Web.Based.Travel.Expense.Tracker.Service;



import com.example.Web.Based.Travel.Expense.Tracker.Entity.ReportEntity;

import com.example.Web.Based.Travel.Expense.Tracker.Repository.ReportRepository;
import com.example.Web.Based.Travel.Expense.Tracker.Entity.UserEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    public ReportService(ReportRepository reportRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    public List<ReportEntity> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<ReportEntity> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    public ReportEntity createReport(ReportEntity report, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        report.setUser(user);
        return reportRepository.save(report);
    }

    public ReportEntity updateReport(Long id, ReportEntity updatedReport) {
        return reportRepository.findById(id)
                .map(report -> {
                    report.setDescription(updatedReport.getDescription());
                    report.setAmount(updatedReport.getAmount());
                    report.setDate(updatedReport.getDate());
                    report.setCategory(updatedReport.getCategory());
                    return reportRepository.save(report);
                })
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
