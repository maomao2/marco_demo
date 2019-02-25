package com.marco.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = { "com.marco.demo.shiro", "com.marco.demo.entity", "com.marco.demo.config",
		"com.marco.demo.controller", "com.marco.demo.service" })
public class Application {

	protected final static Logger logger = LoggerFactory.getLogger("test");

	public static void main(String[] args) {
//		 SpringApplication.run(Application.class, args);

		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		logger.info("PortalApplication is success!");
		System.err.println("sample started. http://localhost:8080/auth/login_page");

	}

}
