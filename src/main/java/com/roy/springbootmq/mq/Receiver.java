package com.roy.springbootmq.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    //定义监听的目标地址
    @JmsListener(destination = "my-dest")
    public void receiveMessage(String message){
        System.out.println("ActiveMQ接收到: <" + message + ">");
    }
}
