package com.hq.test.message.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import com.hq.test.message.CodeNotFoundException;
import com.hq.test.message.MessageSource;
import com.hq.test.message.ResourceReadException;

@Component("platform-message-source")
public class DefaultMessageSource implements MessageSource {

	
	private Properties messageSources;
	
	public DefaultMessageSource(){
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		messageSources = new Properties();
		try {
			Resource[] resources = resolver.getResources("classpath:cfg/*_config.properties");
			for(Resource resource : resources){
				PropertiesLoaderUtils.fillProperties(messageSources, resource);
			}
		} catch (IOException e) {
			throw new ResourceReadException(e);
		}
	}
	
	@Override
	public String getMessage(String code,String fileName){
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Properties properties = new Properties();
		String format = "";
		try {
			Resource resource = resolver.getResource("classpath:cfg/"+fileName);
			PropertiesLoaderUtils.fillProperties(properties, resource);
			format = properties.getProperty(code);
			if(StringUtils.isEmpty(format)){
				throw new CodeNotFoundException();
			}
		} catch (IOException e) {
			throw new ResourceReadException(e);
		}
		return MessageFormat.format(format,"");
	}

	@Override
	public String getMessage(String code, Object[] args) {
		String format = messageSources.getProperty(code);
		if(StringUtils.isEmpty(format)){
			throw new CodeNotFoundException();
		}
		
		return MessageFormat.format(format, args);
	}

	@Override
	public String getMessage(String code, Object[] args, String defaultMessage) {
		String message = null;
		try{
			message = this.getMessage(code, args);
		}catch(CodeNotFoundException e){
			//do nothing
		}
		if(StringUtils.isEmpty(message)){
			return defaultMessage;
		}
		return message;
	}

}