package com.sucheta.springwebflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sucheta.springwebflux.dao.MessageDao;
import com.sucheta.springwebflux.dto.Message;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageHandler {
	@Autowired
	private MessageDao dao;
	
	public Mono<ServerResponse> loadMessages(ServerRequest request){
		Flux<Message> messageList=dao.getMessageList();
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
				.body(messageList,Message.class);
	}
	
	public Mono<ServerResponse> findMessage(ServerRequest request){
		int messageId=Integer.valueOf(request.pathVariable("input"));
		Mono<Message> messageMono=dao.getMessageList().filter(m->m.getId()==messageId).next();
		return ServerResponse.ok()
				.body(messageMono,Message.class);
	}
	
	public Mono<ServerResponse> saveMessage(ServerRequest request){
		
		Mono<Message>   messagemono=request.bodyToMono(Message.class);
		Mono<String> saveMessage= messagemono.map(m->m.getId()+"  "+m.getName());
		return ServerResponse.ok()
				.body(saveMessage,Message.class);
	}

}
