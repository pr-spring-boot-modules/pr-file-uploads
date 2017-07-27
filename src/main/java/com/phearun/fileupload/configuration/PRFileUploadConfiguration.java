package com.phearun.fileupload.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.phearun.fileupload.properties.PRFileUploadProperties;

@Configuration
public class PRFileUploadConfiguration extends WebMvcConfigurerAdapter{

	private PRFileUploadProperties fileProp;
	
	@Autowired
	public PRFileUploadConfiguration(PRFileUploadProperties fileProp) {
		this.fileProp = fileProp;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(fileProp.getClientPath() + "/**").addResourceLocations("file:" + fileProp.getServerPath());
	}
	
}
