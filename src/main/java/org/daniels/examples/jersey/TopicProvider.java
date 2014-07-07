package org.daniels.examples.jersey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class TopicProvider {

	@Autowired
	private SimpMessagingTemplate template;
	
	public SimpMessagingTemplate getTopic() {
		return template;
	}
	
	
}
