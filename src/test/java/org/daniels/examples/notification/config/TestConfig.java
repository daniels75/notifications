package org.daniels.examples.notification.config;

import org.daniels.examples.notification.service.NotificationMessageService;
import org.daniels.examples.notification.service.NotificationSourceService;
import org.daniels.examples.notification.service.impl.NotificationMessageServiceImpl;
import org.daniels.examples.notification.service.impl.NotificationSourceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "org.daniels.examples.notification.repository", "org.daniels.examples.notification.controller" })
public class TestConfig {
    
    @Bean
    public NotificationMessageService getNotificationMessageService() {
        return new NotificationMessageServiceImpl();
    }
    
    @Bean
    public NotificationSourceService getNotificationSourceService() {
        return new NotificationSourceServiceImpl();
    }
}
