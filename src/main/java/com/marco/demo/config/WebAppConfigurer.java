package com.marco.demo.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.marco.demo.entity.properties.DemoConfig;
import com.marco.demo.interceptor.LoginInterceptor;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
	@Resource
	private DemoConfig config;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/**").addResourceLocations("file:/" + config.getUploadPath());
		super.addResourceHandlers(registry);
	}

}
