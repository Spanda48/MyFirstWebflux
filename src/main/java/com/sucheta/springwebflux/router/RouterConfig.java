package com.sucheta.springwebflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.sucheta.springwebflux.handler.MessageHandler;
import com.sucheta.springwebflux.handler.MessageStreamHandler;

@Configuration
public class RouterConfig {
	@Autowired
	private MessageHandler handler;
	@Autowired
	private MessageStreamHandler streamHandler;
	@Bean
	public RouterFunction<ServerResponse> routerFunction(){
		
		return RouterFunctions.route()
				.GET("/router/messages",handler::loadMessages)
				.GET("/router/messages/stream",streamHandler::getMessage)
				.GET("/router/message/{input}",handler::findMessage)
				.POST("/router/message/save",handler::saveMessage)
				.build();
		
		
	}

}
