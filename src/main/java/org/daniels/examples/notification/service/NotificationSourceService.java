package org.daniels.examples.notification.service;

import javax.transaction.Transactional;

import org.daniels.examples.notification.model.NotificationSource;

public interface NotificationSourceService {

	@Transactional
	NotificationSource addSource(final NotificationSource source);
}
