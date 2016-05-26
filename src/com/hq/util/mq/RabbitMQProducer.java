package com.hq.util.mq;   
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.MessageProperties;
 
 
/**
 * 
 * Description: 生产者类的任务是向队列里写消息  
 *
 * ClassName: RabbitMQProducer 
 * date: 2016年3月16日 下午3:35:33    
 *   
 * @author hongxian.song   
 * @version    
 * @since JDK 1.8 
 * Copyright (c) 2016, o2o-lottery All Rights Reserved.
 */
public class RabbitMQProducer extends RabbitMQEntity{
     
    public RabbitMQProducer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }
 
    public void sendMessage(String messgae) throws IOException {
        channel.basicPublish("",endPointName, MessageProperties.PERSISTENT_TEXT_PLAIN, messgae.getBytes("UTF-8"));
    }  
    
}
