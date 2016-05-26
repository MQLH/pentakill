package com.hq.util.mq.exam;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.hq.util.mq.RabbitMQProducer;

/**
 * 
 * Description: TODO  生产者例子
 *
 * ClassName: ProducterExample 
 * date: 2016年5月25日 下午5:43:56    
 *   
 * @author lihao.qiu   
 * @version    
 * @since JDK 1.8 
 * Copyright (c) 2016, o2o-lottery All Rights Reserved.
 */
public class ProducterExample {
	public static void main(String[] args) throws IOException, TimeoutException {
		String channel = "channel_test";
		String sendMsg = "message_test";
		RabbitMQProducer pro = new RabbitMQProducer(channel);
		pro.sendMessage(sendMsg);
	}
}
