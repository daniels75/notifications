package org.daniels.examples.notification.repository;

import org.daniels.examples.notification.model.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotificationTypeJpaRepository  extends JpaRepository<NotificationType, Long> {

	@Query("select u from NotificationType u inner join u.source src where u.name = ?1 and src.name = ?2 and u.source.id = src.id")
	NotificationType findByNameAndSource(final String type, final String source);
}
