package com.activemessure.domain.repositories;
import org.springframework.data.repository.CrudRepository;

import com.activemessure.persistence.entities.test.Note;

public interface NoteRepository extends CrudRepository<Note, String>{

}
