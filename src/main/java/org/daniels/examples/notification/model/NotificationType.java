package org.daniels.examples.notification.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "NotificationType")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "name")
public class NotificationType implements Serializable {

	private static final long serialVersionUID = -6530932410091344970L;
	private Long id;
	private String name;
	private Set<NotificationMessage> messages = new HashSet<>();
	private NotificationSource source;

	public NotificationType(){
	}
	
	public NotificationType(final String name) {
		this.name = name;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 255, nullable = false, unique = true)
    @JsonValue
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch=FetchType.EAGER, mappedBy = "type")
	@JsonIgnore
	public Set<NotificationMessage> getMessage() {
		return messages;
	}

	public void setMessage(Set<NotificationMessage> message) {
		this.messages = message;
	}

	@ManyToOne(optional = false)
	public NotificationSource getSource() {
		return source;
	}

	public void setSource(NotificationSource source) {
		this.source = source;
	}	
	
}
