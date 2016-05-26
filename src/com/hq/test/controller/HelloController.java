package com.hq.test.controller;   

import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hq.test.model.Hehe;
import com.hq.test.service.IHelloService;

/**     
 * Description: TODO  
 *
 * ClassName: HelloController 
 * date: 2016年5月24日 下午3:40:03    
 *   
 * @author mengqiang 
 * @version    
 * @since JDK 1.8 
 * Copyright (c) 2016, o2o-lottery All Rights Reserved.     
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private IHelloService helloService;
	@RequestMapping("/sayHello")
	public void sayHello(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("hello");
		int i = helloService.sayHello("Hello");
		System.out.println(i);
	}
	
	@RequestMapping(consumes = "application/json", method = RequestMethod.POST,value="/hehe")
	@ResponseBody
	public List<Object> sayHehe(@RequestBody Hehe hehe) throws Exception{
		System.out.println(hehe.getCreatetime());
		List<Object> list = new ArrayList<Object>();
		list.add("1");
		list.add("asd");
		list.add(new Date());
		System.out.println(System.currentTimeMillis());
		return list;
	}
}
   
