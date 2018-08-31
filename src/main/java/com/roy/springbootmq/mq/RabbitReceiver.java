package com.roy.springbootmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    @RabbitListener(queues = "my-rabbit-dest")
    public void receiverMessage(String message){
        System.out.println("RabbitMQ接收到: <" + message + ">");
    }
}
