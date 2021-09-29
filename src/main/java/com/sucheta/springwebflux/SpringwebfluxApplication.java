package com.sucheta.springwebflux;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;

import com.sucheta.springwebflux.dto.Message;
import com.sucheta.springwebflux.repo.MessageRepository;

import ch.qos.logback.core.util.Duration;
import io.r2dbc.spi.ConnectionFactory;

@SpringBootApplication
public class SpringwebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebfluxApplication.class, args);
	}
	
	
	 @Bean
	    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

	        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
	        initializer.setConnectionFactory(connectionFactory);
	        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

	        return initializer;
	    }

	    @Bean
	    public CommandLineRunner demo(MessageRepository repository) {

	        return (args) -> {
	            // save messages
	            repository.saveAll(Arrays.asList(new Message(1, "First message"),
	            		new Message(1, "First message"),
	            		new Message(1, "First message")));
	               

	           
	           


	        };
	    }
	
	

}

