package org.daniels.examples.notification.controller;

import org.daniels.examples.notification.model.NotificationMessage;
import org.daniels.examples.notification.service.NotificationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IncomingMessageController {

	@Autowired
	private NotificationMessageService messageService;

	@Autowired
	private SimpMessagingTemplate template;

	private static final String TOPIC = "/topic/greetings";

	@RequestMapping(value = "/notify", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void welcome(@RequestBody final NotificationMessage incomingMessage) {

		final NotificationMessage outgoingMessage = messageService.addNotificationMessage(incomingMessage, "typeA", "sourceA");
		template.convertAndSend(TOPIC, outgoingMessage);
	}
}
