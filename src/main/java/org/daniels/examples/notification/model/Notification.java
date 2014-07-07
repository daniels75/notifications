package org.daniels.examples.notification.model;

public class Notification {
	
	private String name;
	private String content;
	private String url;
	private String user;
	
	public Notification(){
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Notification(final String name, final String content, final String url, final String user) {
		this.name = name;
		this.content = content;
		this.url = url;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}
	
}
