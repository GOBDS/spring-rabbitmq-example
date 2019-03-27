package com.spring.rabbitmq.rpc.example.client;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagerQueueSender {

    private RabbitTemplate rabbitTemplate;
    private DirectExchange exchange;

    @Autowired
    public MessagerQueueSender(RabbitTemplate rabbitTemplate, DirectExchange exchange){
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void send(String message){
        String response = (String) rabbitTemplate.convertSendAndReceive(exchange.getName(), "rpc", message);
        System.out.println("RPC Response = " + response);
    }
}
