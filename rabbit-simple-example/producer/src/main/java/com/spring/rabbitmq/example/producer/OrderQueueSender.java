package com.spring.rabbitmq.example.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    @Autowired
    public OrderQueueSender(RabbitTemplate rabbitTemplate, Queue queue){
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(String order){
        // Como estou utilizando o exchange default o route_key é o nome da queue
        rabbitTemplate.convertAndSend(this.queue.getName(),order);
    }

}
