package com.spring.rabbitmq.rpc.example.server;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @RabbitListener(queues = {"${queue.order.name}"})
    // @SendTo("tut.rpc.replies") used when the
    // client doesn't set replyTo.
    public String receive(@Payload String body){
        return body.concat(" from the other site");
    }
}
