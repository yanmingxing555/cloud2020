package com.yss.springcloud.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import javax.annotation.Resource;

/**
 * @author: ymx
 * @date: 2022/9/6
 * @description: 自定义通道接收消息
 */
@EnableBinding(SelfChannel.class)
public class SelfReceiveMsg {

    @Resource
    private SelfChannel selfChannel;

    /**
     * 接收SelfChannel.INPUT的消息，并且发送一条消息到value = SelfChannel.OUTPUT
     */
    @StreamListener(value = SelfChannel.INPUT)
    public void receive(Message<String> message){
        System.out.println(SelfChannel.INPUT+"接收到消息："+message.toString());
        String msgBody = message.getPayload();
        selfChannel.output().send(MessageBuilder.withPayload("接收消息："+msgBody).build());
    }

    /**
     * 接收SelfChannel.OUTPUT的消息
     */
    @StreamListener(value = SelfChannel.OUTPUT)
    public void receiveEnd(Message<String> message){
        System.out.println(SelfChannel.OUTPUT+"接收到消息："+message.toString());
    }
}
