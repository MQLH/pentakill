package com.hq.test.message;

/**
 * 提供消息文件的读取及参数key的解析。
 * <p>
 *   参数文件可以在各3.0的jar包中，目录和文件名称保持一致。
 *  消息文件存放在 classpath:cfg/messages.properties
 * </p>
 *
 */
public interface MessageSource {
	
	/**
	 * 获取指定code的消息
	 * @param code 消息key
	 * @param args 消息格式参数
	 * @return 格式化后的消息
	 * 例如：
	 * user.name.replicate = {0} 已经存在！
	 * messageSource.getMessage("user.name.replicate",new Object[]{"test"});
	 */
	String getMessage(String code,Object[] args);
	
	/**
	 * 获取指定properties文件 指定code的消息
	 * @param code 消息key
	 * @param args 消息格式参数
	 * @return 格式化后的消息
	 * 例如：
	 * user.name.replicate = {0} 已经存在！
	 * messageSource.getMessage("user.name.replicate",new Object[]{"test"});
	 */
	String getMessage(String code, String fileName);
	
	/**
	 * 获取指定code的消息，当不存在时使用默认消息
	 * @param code 消息key
	 * @param args 消息格式参数
	 * @param defaultMessage 默认消息
	 * @return 格式化后的消息
	 */
	String getMessage(String code,Object[] args,String defaultMessage);

}
