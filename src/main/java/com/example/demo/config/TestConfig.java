
package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties
@Scope("singleton")
@PropertySource(value = {"classpath:/config/properties/application.yml"}, ignoreResourceNotFound=true, factory = YamlPropertySourceFactory.class)
@Data
public class TestConfig {
	public String myqueue;
	
	public Spring spring;
	
	@Data
	public static class Spring {
		@Data
		public static class rabbitmq {
			public String host;
			public String username;
			public String password;
			public String port;
		}
	}

}
