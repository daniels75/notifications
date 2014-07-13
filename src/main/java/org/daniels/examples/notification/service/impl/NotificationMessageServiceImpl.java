package org.daniels.examples.notification.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.daniels.examples.notification.model.NotificationMessage;
import org.daniels.examples.notification.model.NotificationSource;
import org.daniels.examples.notification.model.NotificationType;
import org.daniels.examples.notification.repository.NotificationMessageJpaRepository;
import org.daniels.examples.notification.repository.NotificationSourceJpaRepository;
import org.daniels.examples.notification.repository.NotificationTypeJpaRepository;
import org.daniels.examples.notification.service.NotificationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationMessageServiceImpl implements NotificationMessageService {

	@Autowired
	private NotificationMessageJpaRepository messageRepo;
	
	@Autowired
	private NotificationTypeJpaRepository typeRepo;
	
	@Autowired
	private NotificationSourceJpaRepository sourceRepo;

	public List<NotificationMessage> getNotificationMessages() {
		List<NotificationMessage> messages = messageRepo.findAll();
		return messages;
	}
	
	@Transactional()
	public NotificationMessage addNotificationMessage(final NotificationMessage inMessage, final String type, final String source) {
	    
		NotificationType notificationType = typeRepo.findByNameAndSource(type, source);
		inMessage.setType(notificationType);
		final NotificationMessage outMessage = messageRepo.saveAndFlush(inMessage);
		return outMessage;
	}
}
