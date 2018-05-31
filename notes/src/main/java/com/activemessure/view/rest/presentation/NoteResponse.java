package com.activemessure.view.rest.presentation;

import java.util.List;

import com.activemessure.persistence.entities.test.Note;

public class NoteResponse  extends BaseRepresentation{
    private long id;
    private String content;
    private String userId;
    private List<Note> notes;
    
    public NoteResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }
    
    public NoteResponse(){
    	
    }
    		
	public long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public void setId(long id) {
		this.id = id;
	}
    
    

}
