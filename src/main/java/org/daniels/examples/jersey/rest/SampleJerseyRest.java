package org.daniels.examples.jersey.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daniels.examples.jersey.SampleService;
import org.daniels.examples.jersey.TopicProvider;
import org.daniels.examples.notification.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Path("/sample")
public class SampleJerseyRest {

	private final transient Log logger = LogFactory.getLog(SampleJerseyRest.class);

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	SampleService sampleService;

	@Autowired
	private SimpMessagingTemplate template;

	private static final String TOPIC = "/topic/greetings";

	@GET
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Message savePayment() {

		String result = sampleService.save();

		// return Response.status(200).entity(result).build();
		template.convertAndSend(TOPIC, new Message("3 >>>> save action!"));
		logger.info("Jersey save action");

		return new Message("Jersey save action");
	}

}