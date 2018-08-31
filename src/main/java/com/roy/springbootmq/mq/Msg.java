package com.roy.springbootmq.mq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class Msg implements MessageCreator {

    private String message;

    public Msg(){
        this("测试消息");
    }

    public Msg(String message){
        this.message = message;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(message);
    }
}
