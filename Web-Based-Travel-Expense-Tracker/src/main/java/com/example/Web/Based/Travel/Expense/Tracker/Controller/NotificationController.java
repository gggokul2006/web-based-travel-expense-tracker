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

import com.example.Web.Based.Travel.Expense.Tracker.Entity.NotificationEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin("*") // Enable CORS if needed
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<NotificationEntity>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationEntity> getNotificationById(@PathVariable Long id) {
        Optional<NotificationEntity> notification = notificationService.getNotificationById(id);
        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<NotificationEntity> createNotification(@PathVariable Long userId, @RequestBody NotificationEntity notification) {
        return ResponseEntity.ok(notificationService.createNotification(notification, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationEntity> updateNotification(@PathVariable Long id, @RequestBody NotificationEntity updatedNotification) {
        return ResponseEntity.ok(notificationService.updateNotification(id, updatedNotification));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
