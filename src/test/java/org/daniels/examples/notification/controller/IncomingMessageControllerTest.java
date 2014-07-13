package org.daniels.examples.notification.controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.daniels.examples.notification.config.JpaTestConfig;
import org.daniels.examples.notification.config.TestConfig;
import org.daniels.examples.notification.model.NotificationMessage;
import org.daniels.examples.notification.model.NotificationSource;
import org.daniels.examples.notification.model.NotificationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaTestConfig.class, TestConfig.class })
public class IncomingMessageControllerTest {

    @Test
    public void testSendMessage() throws Exception {
        final NotificationType type = new NotificationType("typeA");
        final NotificationSource source = new NotificationSource("sourceA");
        source.addType(type);
        type.setSource(source);
        
        NotificationMessage first = new NotificationMessage("cont1", "url1");
        first.setType(type);
        final Date date = new Date();
        first.setCreatedAt(new Date());
        first.setUserName("testUser");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        final String output = mapper.writeValueAsString(first);
        assertEquals("{\"source\":\"sourceA\",\"type\":\"typeA\",\"user\":\"testUser\",\"url\":\"typeA\",\"content\":\"cont1\",\"createdAt\":"+ date.getTime() +"}", output);
    }
}
