package com.hq.test.model;   

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**     
 * Function: TODO 
 *
 * ClassName:Hehe 
 * Date:     2016年5月25日 下午3:42:55    
 * @author   mengq   
 * @version     
 * @since    JDK 1.8   
 * Copyright (c) 2016, palm-commerce All Rights Reserved.         
 */
public class Hehe {
	private String name;
	private String age;
	private Date createtime;
	public Hehe() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}
   
