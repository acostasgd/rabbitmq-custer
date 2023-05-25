package com.rabbitmq.cluster.configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

  @Bean
  public RabbitTemplate newsEventClient(ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitClient = new RabbitTemplate();
    rabbitClient.setExchange("exchange.news.event");
    rabbitClient.setConnectionFactory(connectionFactory);
    return rabbitClient;
  }
}
