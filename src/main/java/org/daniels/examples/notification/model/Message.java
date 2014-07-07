package org.daniels.examples.notification.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {

	private String content;

	public Message(){
		
	}
	
	public Message(final String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

}
