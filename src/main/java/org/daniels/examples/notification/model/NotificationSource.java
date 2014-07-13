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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "NotificationSource")
public class NotificationSource implements Serializable {

	private static final long serialVersionUID = 5317542965335621196L;
	private Long id;
	private String name;
	private Set<NotificationType> types = new HashSet<>();

	public NotificationSource(){
	}
	
	public NotificationSource(final String name) {
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "source", cascade=CascadeType.ALL)
	@JsonIgnore
	public Set<NotificationType> getTypes() {
		return types;
	}

	public void setTypes(Set<NotificationType> types) {
		this.types = types;
	}

    public void addType(final NotificationType type) {
        this.types.add(type);
    }	
	
}
