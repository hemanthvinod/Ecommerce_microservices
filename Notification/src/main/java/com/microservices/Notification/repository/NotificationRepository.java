package com.microservices.Notification.repository;

import com.microservices.Notification.domain.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface NotificationRepository extends MongoRepository<Notification, String> {

}

