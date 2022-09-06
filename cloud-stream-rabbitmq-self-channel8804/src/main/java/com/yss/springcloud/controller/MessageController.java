package com.yss.springcloud.controller;

import com.yss.springcloud.channel.SelfChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: ymx
 * @date: 2022/9/6
 * @description:
 */
@RestController
public class MessageController {
    @Resource
    private SelfChannel selfChannel;

    /**
     * 发送消息到elfChannel.INPUT通道
     */
    @GetMapping("/sendMsg")
    public String sendMsg(){
        String msg = UUID.randomUUID().toString();
        selfChannel.sendMsgChannel().send(MessageBuilder.withPayload(msg).build());
        return "发送消息："+msg;
    }
}
