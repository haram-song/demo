
package com.example.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Component

public class Send {
	
	private final static String QUEUE_NAME = "hello";
	
//	@Value("${spring.rabbitmq.host}")
//	private static String hostIp;
//	
//	@Value("${spring.rabbitmq.port}")
//	private static int port;
	

	private static final Logger logger = LoggerFactory.getLogger(Send.class);
	
	public static void main(String[] args) throws IOException, TimeoutException {
//		logger.debug("hostIp==" + hostIp);
//		logger.debug("port===" + port);
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		String message = "Hello world!";
		
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8")); // hello 라는 QUEUE에 "Hello World!" 메시지를 발행하고 프로그램을 종료한다.
		
		logger.debug("[x] sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
}
