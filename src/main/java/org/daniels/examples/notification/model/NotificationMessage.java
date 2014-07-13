package org.daniels.examples.notification.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.daniels.examples.notification.json.OutgoingMessageSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "NotificationMessage")
@JsonSerialize(using = OutgoingMessageSerializer.class)
public class NotificationMessage implements Serializable {

	private static final long serialVersionUID = -5381234840284081212L;
	
	private Long id;
	private String content;
	private String url;
	private String userName;
	private NotificationType type;
	private Date createdAt;

	public NotificationMessage(){
	}
	
	public NotificationMessage(final String content, final String url) {
		this.content = content;
		this.url = url;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }	

	public void setContent(String content) {
		this.content = content;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUserName(String user) {
		this.userName = user;
	}

	@Column(length = 64)
	public String getContent() {
		return content;
	}

	@Column(length = 64)
	public String getUrl() {
		return url;
	}

	@Column(length = 64)
	public String getUserName() {
		return userName;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType notificationType) {
		this.type = notificationType;
	}

	@Column
	public Date getCreatedAt() {
		return createdAt;
	}
	
	@PrePersist
	void createdAt() {
		createdAt = new Date();
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
