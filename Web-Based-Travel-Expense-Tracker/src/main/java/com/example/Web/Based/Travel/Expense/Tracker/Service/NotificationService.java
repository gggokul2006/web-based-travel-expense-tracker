package com.example.Web.Based.Travel.Expense.Tracker.Service;


import com.example.Web.Based.Travel.Expense.Tracker.Entity.NotificationEntity;

import com.example.Web.Based.Travel.Expense.Tracker.Repository.NotificationRepository;
import com.example.Web.Based.Travel.Expense.Tracker.Entity.UserEntity;
import com.example.Web.Based.Travel.Expense.Tracker.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public List<NotificationEntity> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<NotificationEntity> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public NotificationEntity createNotification(NotificationEntity notification, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        notification.setUser(user);
        return notificationRepository.save(notification);
    }

    public NotificationEntity updateNotification(Long id, NotificationEntity updatedNotification) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    notification.setDescription(updatedNotification.getDescription());
                    notification.setAmount(updatedNotification.getAmount());
                    notification.setDate(updatedNotification.getDate());
                    notification.setCategory(updatedNotification.getCategory());
                    return notificationRepository.save(notification);
                })
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
