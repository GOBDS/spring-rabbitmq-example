# Simple RPC (Remote Procedure Call) example using spring cloud and rabbitMQ

What if we need to run a function on a remote computer and wait for the result? This is possible using RabbitMQ. This pattern is commonly known as _Remote Procedure Call_ or _RPC_.

For more infomartion go to: [tutorial-six-spring-amqp](https://www.rabbitmq.com/tutorials/tutorial-six-spring-amqp.html)

  ### Project message flow:
```mermaid
graph LR
A((Client)) --> B{RPC Exchange}
B --> C(RPC Queue)
C --> D((Server))
D --> E{Default Exchange}
E --> F(Reply Queue)
F --> A
