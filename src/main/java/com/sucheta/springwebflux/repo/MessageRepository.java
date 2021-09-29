package com.sucheta.springwebflux.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.sucheta.springwebflux.dto.Message;

import reactor.core.publisher.Flux;


@Repository
public interface MessageRepository extends ReactiveCrudRepository<Message, Integer> {

	
	 @Query("SELECT * FROM Message WHERE id = :id")
	    Flux<Message> findById(int id);
}