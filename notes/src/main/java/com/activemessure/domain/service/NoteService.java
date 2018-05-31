package com.activemessure.domain.service;

import java.util.List;

import com.activemessure.persistence.entities.test.Note;
import com.activemessure.view.rest.presentation.NoteRequest;

public interface NoteService {
	
	public List<Note> findAllNotesByUserId(String userId);
	
	public Note addNewNote(NoteRequest param);
	
	public Note updateNote(NoteRequest param);
	
	public void deleteNote(NoteRequest param);

}
