package com.pcr.demo.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String,Object> redisTemplate(){
		final RedisTemplate<String,Object> template = new RedisTemplate<String,Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}
	
	
	/*
	 * @Bean JedisConnectionFactory connectionFactory() { JedisConnectionFactory
	 * factory = new JedisConnectionFactory(); return factory; }
	 * 
	 * @Bean public RedisTemplate<String,String> redisTemplate(){
	 * RedisTemplate<String,String> template = new RedisTemplate<>();
	 * template.setConnectionFactory(connectionFactory());
	 * template.setValueSerializer(new
	 * GenericToStringSerializer<String>(String.class)); return template; }
	 * 
	 * @Bean ChannelTopic topic() { return new
	 * ChannelTopic(UUID.randomUUID().toString()); }
	 * 
	 * @Bean RedisMessageListenerContainer redisContainer() {
	 * RedisMessageListenerContainer container = new
	 * RedisMessageListenerContainer();
	 * container.setConnectionFactory(connectionFactory());
	 * container.addMessageListener(new MessageListenerAdapter(new
	 * RedisReciever()),topic());
	 * container.setTaskExecutor(Executors.newFixedThreadPool(4)); return container;
	 * }
	 */
}
