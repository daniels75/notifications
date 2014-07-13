package org.daniels.examples.notification.service.impl;

import javax.transaction.Transactional;

import org.daniels.examples.notification.model.NotificationSource;
import org.daniels.examples.notification.repository.NotificationSourceJpaRepository;
import org.daniels.examples.notification.repository.NotificationTypeJpaRepository;
import org.daniels.examples.notification.service.NotificationSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSourceServiceImpl implements NotificationSourceService {

    @Autowired
    private NotificationSourceJpaRepository sourceRepo;

    @Autowired
    private NotificationTypeJpaRepository typeRepo;

    @Override
    @Transactional()
    public NotificationSource addSource(final NotificationSource source) {
        final NotificationSource outSource = sourceRepo.saveAndFlush(source);
        return outSource;
    }
}
