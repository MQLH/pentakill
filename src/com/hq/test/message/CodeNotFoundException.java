package com.hq.test.message;

/**
 * code未在资源文件中找到
 */
public class CodeNotFoundException extends RuntimeException{
	/**
	 * 自动生成
	 */
	private static final long serialVersionUID = 4165989445913787285L;

	public CodeNotFoundException(){
		super("code没有在资源文件中找到");
	}
	
	public CodeNotFoundException(String msg){
		super(msg);
	}
	
	public CodeNotFoundException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public CodeNotFoundException(Throwable cause){
		super("code没有在资源文件中找到",cause);
	}
}
