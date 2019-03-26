package com.spring.rabbitmq.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderQueueSender orderQueueSender;

    @Autowired
    public OrderController(OrderQueueSender orderQueueSender){
        this.orderQueueSender = orderQueueSender;
    }

    @PostMapping
    public void createOrder(){
        orderQueueSender.send("Queue Test");
    }
}
