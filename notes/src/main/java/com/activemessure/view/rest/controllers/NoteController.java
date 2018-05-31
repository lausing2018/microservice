package com.activemessure.view.rest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.activemessure.view.rest.presentation.NoteResponse;


@RestController
@RequestMapping({ "/api/v1/note", "/note" })
public class NoteController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public NoteResponse getAllNotes(@RequestParam(value="name", defaultValue="World") String name) {
        return new NoteResponse(counter.incrementAndGet(),
                            String.format(template, name));
    }
}