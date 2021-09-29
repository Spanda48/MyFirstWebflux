package com.sucheta.springwebflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sucheta.springwebflux.dao.MessageDao;
import com.sucheta.springwebflux.dto.Message;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageStreamHandler {
	
	
	@Autowired
	private MessageDao dao;
	
	public Mono<ServerResponse> getMessage(ServerRequest request){
	Flux<Message> messageStream=dao.getMessageStream();
	return ServerResponse.ok().body(messageStream,Message.class);
		
	}

}
