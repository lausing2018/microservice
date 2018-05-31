package com.activemessure.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activemessure.domain.repositories.NoteRepository;
import com.activemessure.domain.service.UserService;
import com.activemessure.persistence.entities.test.Note;
import com.activemessure.domain.service.NoteService;;

@Service
@Transactional
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NoteRepository noteRepo;
	
	@Override
	public List<Note> findAllNotesByUserId(String userId) {

		List<Note> notes = new ArrayList<>();
		try {
			
			notes = noteRepo.findByUserId(userId);
			
			
		}catch(Exception ex){
			System.out.println("Log exception:"+ex.getMessage());
		}

		return notes;
	}

}
