package com.spring.rabbitmq.rpc.example.client;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tut.rpc");
    }
}
