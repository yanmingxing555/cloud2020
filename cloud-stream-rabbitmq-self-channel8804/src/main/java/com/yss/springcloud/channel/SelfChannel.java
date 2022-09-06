package com.yss.springcloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author: ymx
 * @date: 2022/9/6
 * @description: 自定义通道
 */
public interface SelfChannel {
    String INPUT = "test-input";
    String OUTPUT = "test-output";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();

    @Output(INPUT)
    MessageChannel sendMsgChannel();
}
