package com.spring.rabbitmq.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = {"${queue.order.name}"})
    public void receive(@Payload String body){
        System.out.println("Order: " + body);
    }
}
