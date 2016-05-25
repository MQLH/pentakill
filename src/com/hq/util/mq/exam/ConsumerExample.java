package com.hq.util.mq.exam;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import com.hq.util.mq.RabbitMQEntity;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * Description: TODO 消费者例子
 *
 * ClassName:ConsumerExample Date: 2016年4月6日 下午16:27:26
 * 
 * @author lihao.qiu
 * @version
 * @since JDK 1.8 Copyright (c) 2016, o2o-lottery All Rights Reserved.
 */
public class ConsumerExample extends RabbitMQEntity implements Consumer {

	private static Logger logger = Logger.getLogger(ConsumerExample.class);
	private static final String CHANNEL_NAME = "channel_test";

	public ConsumerExample() throws IOException, TimeoutException {

		super(CHANNEL_NAME);

		run();
	}

	public void run() {
		try {
			// 指定该消费者同时只接收一条消息
			channel.basicQos(1);
			// 自动通知标志
			boolean autoAck = false;
			// 打开消息应答机制
			channel.basicConsume(endPointName, autoAck, this);
		} catch (IOException e) {
			logger.error("ConsumerExample start()异常", e);
		}
	}

	/**
	 * Called when consumer is registered.
	 */
	public void handleConsumeOk(String consumerTag) {
		logger.info("ConsumerExample " + consumerTag + " registered");
	}

	/**
	 * Called when new message is available.
	 */
	public void handleDelivery(String consumerTag, Envelope env,
			BasicProperties props, byte[] body) throws IOException {
		String message = new String(body, "UTF-8");
		logger.info("message Is " + message);
		// 返回接收到消息的确认信息，将数据从队列中DQ
		channel.basicAck(env.getDeliveryTag(), false);
	}

	public void handleCancel(String consumerTag) {
	}

	public void handleCancelOk(String consumerTag) {
	}

	public void handleRecoverOk(String consumerTag) {
	}

	public void handleShutdownSignal(String consumerTag,
			ShutdownSignalException arg1) {
	}
}
