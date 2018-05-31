package com.activemessure.domain.service;

import java.util.List;

import com.activemessure.persistence.entities.test.Note;

public interface NoteService {
	
	public List<Note> findAllNotesByUserId(String userId);

}
