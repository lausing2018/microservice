package com.activemessure.persistence.entities.test;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


/**
 * The persistent class for the note database table.
 * 
 */
@Entity
@Table(name="note")
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name="note_id",updatable = false, nullable = false)
	private String noteId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_time")
	private Date lastUpdatedTime;

	@Column(length = 1000)
	private String notes;
	
	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="user_id")
//	private User user;
	
	@Column(name="user_id")
	private String userId;

	@NotBlank
	@Column(length = 50)
	private String title;

	public Note() {
	}

	public String getNoteId() {
		return this.noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastUpdatedTime() {
		return this.lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

/*	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

		
}