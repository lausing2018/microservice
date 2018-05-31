package com.activemessure.view.rest.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.activemessure.domain.service.NoteService;
import com.activemessure.domain.service.UserService;
import com.activemessure.view.rest.presentation.NoteRequest;
import com.activemessure.view.rest.presentation.NoteResponse;
import com.activemessure.persistence.entities.test.Note;


@RestController
@RequestMapping({ "/api/v1/note", "/note" })
public class NoteController {

	
	//@Autowired
	//private UserService userService;
	
	@Autowired
	private NoteService noteService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
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
    
	@RequestMapping(value="/add/",method=RequestMethod.POST)
	public NoteResponse addNewNote( @RequestBody NoteRequest noteRequest){
		NoteResponse response = new NoteResponse();
		
		if(noteRequest==null){

			response.setStatusCode("404");
			response.setMessage("noteRequest cannot be null");
			return response;

		}
		else if(noteRequest.getUserId().isEmpty() || noteRequest.getUserId() == null) {
			response.setStatusCode("404");
			response.setMessage("User Id cannot be null or empty");
			return response;
		}
		else if(noteRequest.getTitle() == null || noteRequest.getTitle().isEmpty()){
			
			response.setStatusCode("404");
			response.setMessage("Title cannot be null or empty");
			return response;

		}
		Note note = noteService.addNewNote(noteRequest);
		if(note != null){
			response.setStatusCode("200");
			response.setMessage("Successful");	
		}
		else{
			response.setStatusCode("500");
			response.setMessage("Cannot add note");
		}
    	
		return response;
	}
	
	@RequestMapping(value="/update/",method=RequestMethod.PUT)
	public NoteResponse updateNote( @RequestBody NoteRequest noteRequest){
		NoteResponse response = new NoteResponse();
		
		if(noteRequest==null){

			response.setStatusCode("404");
			response.setMessage("noteRequest cannot be null");
			return response;

		}
		else if(noteRequest.getNoteId().isEmpty() || noteRequest.getNoteId() == null) {
			response.setStatusCode("404");
			response.setMessage("Note Id cannot be null or empty");
			return response;
		}
		else if(noteRequest.getUserId().isEmpty() || noteRequest.getUserId() == null) {
			response.setStatusCode("404");
			response.setMessage("User Id cannot be null or empty");
			return response;
		}
		else if(noteRequest.getTitle() == null || noteRequest.getTitle().isEmpty()){
			
			response.setStatusCode("404");
			response.setMessage("Title cannot be null or empty");
			return response;

		}
		Note note = noteService.addNewNote(noteRequest);
		if(note != null){
			response.setStatusCode("200");
			response.setMessage("Successful");	
		}
		else{
			response.setStatusCode("500");
			response.setMessage("Cannot add note");
		}
    	
		return response;
	}

    
}