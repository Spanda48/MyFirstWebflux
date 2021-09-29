package com.sucheta.springwebflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sucheta.springwebflux.dao.MessageDao;
import com.sucheta.springwebflux.dto.Message;
import com.sucheta.springwebflux.repo.MessageRepository;

import reactor.core.publisher.Flux;

@Service
public class MessageSevice {
	@Autowired
	private MessageDao dao;
	
	@Autowired
	private MessageRepository repository;

	public List<Message> LoadAllMessage() {

		List<Message> message = dao.getMessage();
		return message;

	}

	public Flux<Message> LoadAllMessageStream() {

		Flux<Message> message = dao.getMessageStream();
		return message;

	}

}
