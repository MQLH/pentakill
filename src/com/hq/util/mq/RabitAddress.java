package com.hq.util.mq;   

import com.rabbitmq.client.Address;

/**     
 * Description: TODO 
 *
 * ClassName:RabitAddress 
 * Date:     2016年3月14日 下午6:04:20    
 * @author   hongxian.song   
 * @version     
 * @since    JDK 1.8   
 * Copyright (c) 2016, o2o-lottery All Rights Reserved.         
 */
public class RabitAddress extends Address{
    /**
     * 账号
     */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
    /**
     * 	虚拟机
     */
	private String virtualHost;

	public RabitAddress(String host, int port, String username,
			String password, String virtualHost) {
		super(host, port);
		this.username = username;
		this.password = password;
		this.virtualHost = virtualHost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVirtualHost() {
		return virtualHost;
	}

	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}
}
   
