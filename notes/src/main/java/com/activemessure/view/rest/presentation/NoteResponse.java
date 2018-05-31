package com.activemessure.view.rest.presentation;

public class NoteResponse {
    private final long id;
    private final String content;
    
    public NoteResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }
    
	public long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
    
    

}
