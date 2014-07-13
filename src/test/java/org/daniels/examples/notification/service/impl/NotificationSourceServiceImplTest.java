package org.daniels.examples.notification.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.daniels.examples.notification.config.JpaTestConfig;
import org.daniels.examples.notification.config.TestConfig;
import org.daniels.examples.notification.model.NotificationSource;
import org.daniels.examples.notification.model.NotificationType;
import org.daniels.examples.notification.service.NotificationSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaTestConfig.class, TestConfig.class })
public class NotificationSourceServiceImplTest
{
    @Autowired
    private NotificationSourceService myService;

    protected ApplicationContext applicationContext;

    @Test
    public void testCreateAndRetrieve() {
        NotificationSource retr = myService.addSource(new NotificationSource("testSource2"));
        assertNotNull(retr);
        assertEquals("testSource2", retr.getName());
    }

    @Test
    public void testCreateWithTypes() {
        NotificationType type1 = new NotificationType("type1");
        NotificationType type2 = new NotificationType("type2");
        NotificationType type3 = new NotificationType("type3"); // not inserted

        NotificationSource source = new NotificationSource("testSource1");
        source.addType(type1);
        source.addType(type2);
        type1.setSource(source);
        type2.setSource(source);

        final NotificationSource retr = myService.addSource(source);

        assertNotNull(retr);
        assertEquals("testSource1", retr.getName());
        assertTrue(retr.getTypes().contains(type1));
        assertTrue(retr.getTypes().contains(type2));
        assertFalse(retr.getTypes().contains(type3));
    }

    // @Test
    // public void testCreateAndRetrieve() {
    // NotificationSource retr = myService.addSource(new NotificationSource("testSource"));
    // assertNotNull(retr);
    // assertEquals("testSource", retr.getName());
    // }
}
