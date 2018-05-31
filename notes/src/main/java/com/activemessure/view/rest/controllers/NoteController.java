package com.activemessure.view.rest.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.activemessure.domain.service.NoteService;
import com.activemessure.domain.service.UserService;
import com.activemessure.view.rest.presentation.NoteResponse;
import com.activemessure.persistence.entities.test.Note;


@RestController
@RequestMapping({ "/api/v1/note", "/note" })
public class NoteController {

	
	//@Autowired
	//private UserService userService;
	
	@Autowired
	private NoteService noteService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public NoteResponse getAllNotes() {
    	
    	
    	
    	
        return new NoteResponse(10,"Hello!!!");
    }
    
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public NoteResponse getNotesByUserId(@PathVariable("userId") String userId) {
    	
    	NoteResponse response = new NoteResponse();
    	
    	if(userId == null ||userId.isEmpty()){
    		response.setStatusCode("404");
    		response.setMessage("User Id cannot be null or empty");
    		return response;
    	}
    	
    	List<Note> notes = noteService.findAllNotesByUserId(userId);
    	
    	response.setStatusCode("200");
		response.setMessage("Successful");
    	response.setUserId(userId);
    	response.setNotes(notes);
    	
        return response;
    }
}