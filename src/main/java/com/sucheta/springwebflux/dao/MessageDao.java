package com.sucheta.springwebflux.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.sucheta.springwebflux.dto.Message;

import reactor.core.publisher.Flux;

@Component
public class MessageDao {

	public List<Message> getMessage() {
	return	IntStream.rangeClosed(1, 50).peek(i->System.out.println("processing count"+i))
		         .mapToObj(i -> new Message(i, "message :"+ i)).collect(Collectors.toList());

	}
	
	public Flux<Message> getMessageStream() {
		return	Flux.range(1, 50)
				.doOnNext(i->System.out.println("processing count"+i))
				.map(i -> new Message(i, "message :"+ i));

		}
	
	public Flux<Message> getMessageList() {
		return	Flux.range(1, 50)
				.doOnNext(i->System.out.println("processing count"+i))
				.map(i -> new Message(i, "message :"+ i));

		}


}
