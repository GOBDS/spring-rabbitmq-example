# Simple example using spring cloud and rabbitMQ

Just a simple project demonstrating the basic usage of spring cloud with rabbitMQ.

  ### Project message flow:
```mermaid
graph LR
A((Producer)) --> B{Default Exchange}
B --> C(OrderQueue)
C --> D((Consumer))