package org.daniels.examples.notification.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.daniels.examples.notification.config.JpaTestConfig;
import org.daniels.examples.notification.config.TestConfig;
import org.daniels.examples.notification.model.NotificationMessage;
import org.daniels.examples.notification.model.NotificationSource;
import org.daniels.examples.notification.model.NotificationType;
import org.daniels.examples.notification.service.NotificationMessageService;
import org.daniels.examples.notification.service.NotificationSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaTestConfig.class, TestConfig.class })
public class NotificationMessageServiceImplTest
{
    @Autowired
    private NotificationMessageService messageService;
    
    @Autowired
    private NotificationSourceService sourceService;

    protected ApplicationContext applicationContext;
    
    @Test
    public void testCreateMessages() {
        final NotificationType type = new NotificationType("typeA");
        final NotificationSource source = new NotificationSource("sourceA");
        source.addType(type);
        type.setSource(source);
        sourceService.addSource(source);
        
        final NotificationMessage retr1 = messageService.addNotificationMessage(new NotificationMessage(
                "testContent1", "urls"), "typeA", "sourceA");
        final NotificationMessage retr2 = messageService.addNotificationMessage(new NotificationMessage(
                "testContent2", "urls"), "typeA", "sourceA");

        assertNotNull(retr1);
        assertNotNull(retr2);
        assertTrue(retr1.getContent().equals("testContent1"));
        assertTrue(retr2.getContent().equals("testContent2"));
    }
}
