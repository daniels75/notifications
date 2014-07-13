package org.daniels.examples.notification.json;

import java.io.IOException;

import org.daniels.examples.notification.model.NotificationMessage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class OutgoingMessageSerializer extends JsonSerializer<NotificationMessage> {

	@Override
	public void serialize(NotificationMessage message, JsonGenerator generator,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		generator.writeStartObject();
		generator.writeStringField("source", message.getType().getSource().getName());
		generator.writeStringField("type", message.getType().getName());
		generator.writeStringField("user", message.getUserName());
		generator.writeStringField("url", message.getType().getName());
		generator.writeStringField("content", message.getContent());
		generator.writeNumberField("createdAt", message.getCreatedAt().getTime());
		generator.writeEndObject();
	}

	@Override
	public Class<NotificationMessage> handledType() {
		return NotificationMessage.class;
	}

}
