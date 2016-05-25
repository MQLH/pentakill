package com.hq.util.mq;   

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
/**
 * 
 * Description: 抽象类  
 *
 * ClassName: RabbitMQEntity 
 * date: 2016年3月16日 下午3:34:56    
 *   
 * @author hongxian.song   
 * @version    
 * @since JDK 1.8 
 * Copyright (c) 2016, o2o-lottery All Rights Reserved.
 */
public abstract class RabbitMQEntity{
	private static RabitAddress  rabitAddresses = null;
	static{
		InputStream inputStream = null;
        try {
            Properties props = new Properties();  
            //获取配置文件
            inputStream = RabbitMQEntity.class.getResourceAsStream("rabbitmqConfig.properties");
            props.load(inputStream); 
            
            String host = props.getProperty("host");
            int port = Integer.parseInt(props.getProperty("port"));
            String mq_username = props.getProperty("mq_username");
            String mq_password = props.getProperty("mq_password");
            String virtualHost = props.getProperty("virtualHost");
            rabitAddresses = new RabitAddress(host, port, mq_username, mq_password, virtualHost); 
        } catch (Exception e) {
            throw new RuntimeException("rabbitmq资源文件加载失败！", e);   
        }finally{
        	if (inputStream!=null) {
        		try {
					inputStream.close();
				} catch (IOException e) {
					throw new RuntimeException("rabbitmq资源关闭失败！", e);   
				}
			}
        }
	}
	//RabitAddress rabitAddresses = new RabitAddress("192.168.1.115", 5672,"mq","123456","NewEarth"); 
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;
     
    public RabbitMQEntity(String endpointName) throws IOException, TimeoutException{
         this.endPointName = endpointName;
         
         //Create a connection factory
         ConnectionFactory factory = new ConnectionFactory();
         //网络有问题时，好后可自动恢复设置。
         factory.setAutomaticRecoveryEnabled(true);
         
         //设置心跳时间
         factory.setRequestedHeartbeat(5);
         //hostname of your rabbitmq server
         factory.setHost(rabitAddresses.getHost());
         factory.setPort(rabitAddresses.getPort());
         factory.setUsername(rabitAddresses.getUsername());
         factory.setPassword(rabitAddresses.getPassword());
         factory.setVirtualHost(rabitAddresses.getVirtualHost());
         
         //getting a connection
         connection = factory.newConnection();
         
         //creating a channel
         channel = connection.createChannel();
         
         //declaring a queue for this channel. If queue does not exist,
         //it will be created on the server.
         channel.queueDeclare(endpointName, true, false, false, null);
    }
     
     
    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws IOException
     * @throws TimeoutException 
     */
     public void close() throws IOException, TimeoutException{
    	 System.out.println("closecloseclosecloseclose");
         this.channel.close();
         this.connection.close();
     }


	public Channel getChannel() {
		return channel;
	}


	public void setChannel(Channel channel) {
		this.channel = channel;
	}
     
     
}
