package org.daniels.examples.notification.repository;

import org.daniels.examples.notification.model.NotificationSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationSourceJpaRepository  extends JpaRepository<NotificationSource, Long> {

}
