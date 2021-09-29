package com.sucheta.springwebflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sucheta.springwebflux.dto.Message;
import com.sucheta.springwebflux.service.MessageSevice;

import reactor.core.publisher.Flux;

@RestController

@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageSevice service;
	
	
	@GetMapping
	
	public List<Message> getAllMessages(){
		return service.LoadAllMessage();
		
	}
	
	@GetMapping("/stream")
	public Flux<Message> getAllMessagesStream(){
		return service.LoadAllMessageStream();
		
	}

}
