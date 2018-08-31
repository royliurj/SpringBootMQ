package com.roy.springbootmq;


import com.roy.springbootmq.mq.Msg;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.amqp.core.*;

import java.util.Queue;

@SpringBootApplication
public class SpringbootmqApplication implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmqApplication.class, args);
	}

	@Bean
	public org.springframework.amqp.core.Queue wiselyQueue(){
		return new org.springframework.amqp.core.Queue("my-rabbit-dest");
	}

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("my-dest", new Msg("This is test message"));

		rabbitTemplate.convertAndSend("my-rabbit-dest","来自RabbitMQ的问候");
	}
}
