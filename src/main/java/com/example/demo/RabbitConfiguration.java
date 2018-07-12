
package com.example.demo;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 Configuration -> 스프링 설정으로 사용되는 클래스라는 것을 알림 

 */
@Configuration
public class RabbitConfiguration {
	static final String queueName = "spring-boot";
	
   @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }
   
   @Bean
	Queue queue(){
		return new Queue(queueName, false);
	}
   
   @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

   @Bean
   public RabbitTemplate rabbitTemplate() {
       RabbitTemplate template = new RabbitTemplate(connectionFactory());
       template.setRoutingKey(queueName);
       template.setQueue(queueName);
       return template;
   }

		
}
