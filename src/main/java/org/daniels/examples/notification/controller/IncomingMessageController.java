package org.daniels.examples.notification.controller;

import org.daniels.examples.notification.aspect.NotifyClients;
import org.daniels.examples.notification.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping("/")
@EnableAspectJAutoProxy
public class IncomingMessageController {
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	private static final String TOPIC = "/topic/greetings";
	
	@NotifyClients
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody void welcome() {
		template.convertAndSend(TOPIC, new Message("1 >>>> it works with context autowired in rest service!"));
	}
}
