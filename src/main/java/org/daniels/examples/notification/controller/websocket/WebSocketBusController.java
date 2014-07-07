package org.daniels.examples.notification.controller.websocket;

import org.daniels.examples.notification.model.Message;
import org.daniels.examples.notification.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class WebSocketBusController {

	@Autowired
	WebApplicationContext webApplicationContext;
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Message greeting(final Notification message) throws Exception {
		Thread.sleep(200);
		return new Message("hello " + message.getName());
	}

}
