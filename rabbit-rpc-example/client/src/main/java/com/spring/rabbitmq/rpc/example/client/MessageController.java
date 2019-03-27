package com.spring.rabbitmq.rpc.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessagerQueueSender messagerQueueSender;

    @Autowired
    public MessageController(MessagerQueueSender messagerQueueSender){
        this.messagerQueueSender = messagerQueueSender;
    }

    @PostMapping
    public void createMessage(){
        messagerQueueSender.send("hello");
    }
}
