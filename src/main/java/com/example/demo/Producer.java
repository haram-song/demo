package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 */
public class Producer {
	public static void main(String[] args) {
		 // 자바 기반 설정 -> AnnotationConfigApplicationContext 사용
		ApplicationContext context =
                new AnnotationConfigApplicationContext(RabbitConfiguration.class);
        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
        amqpTemplate.convertAndSend("Hello World");
        System.out.println("Sent: Hello World");
		
	}
}
