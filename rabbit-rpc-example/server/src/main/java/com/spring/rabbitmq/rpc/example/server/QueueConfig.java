package com.spring.rabbitmq.rpc.example.server;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Value("${queue.order.name}")
    private String orderQueue;

    @Bean
    public Queue queue() {
        return new Queue(orderQueue);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tut.rpc");
    }

    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("rpc");
    }
}
