package com.sucheta.springwebflux.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Message {
	@Id
	private int id;
	private String name;
	
	
	public Message(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public Message() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + "]";
	}
	
	

}
