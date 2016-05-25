package com.hq.test.message;

/**
 * 资源文件读取异常
 *
 */
public class ResourceReadException extends RuntimeException {

	/**
	 * 自动生成
	 */
	private static final long serialVersionUID = 4165989445913787285L;

	public ResourceReadException(){
		super("资源文件读取错误");
	}
	
	public ResourceReadException(String msg){
		super(msg);
	}
	
	public ResourceReadException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public ResourceReadException(Throwable cause){
		super("资源文件读取错误",cause);
	}	
}
