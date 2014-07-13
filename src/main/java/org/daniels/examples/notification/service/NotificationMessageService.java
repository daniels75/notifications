package org.daniels.examples.notification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.daniels.examples.notification.model.NotificationMessage;

public interface NotificationMessageService {

	List<NotificationMessage> getNotificationMessages();
	
	@Transactional
	NotificationMessage addNotificationMessage(final NotificationMessage message, final String type, final String source);
}
