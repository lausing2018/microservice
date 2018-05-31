package com.activemessure.domain.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.activemessure.persistence.entities.test.Note;

public interface NoteRepository extends CrudRepository<Note, String>{
	
	public List<Note> findByUserId(String userId);

}
