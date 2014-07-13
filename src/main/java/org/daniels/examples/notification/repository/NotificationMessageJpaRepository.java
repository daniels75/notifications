package org.daniels.examples.notification.repository;

import org.daniels.examples.notification.model.NotificationMessage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationMessageJpaRepository  extends JpaRepository<NotificationMessage, Long> {

}
