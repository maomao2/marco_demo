package com.marco.demo.entity.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "demo")
@PropertySource("classpath:config.properties")
@Component
public class DemoConfig {
	// 上传文件绝对路径
	private String uploadPath;
	// 上传文件访问中间路径
	private String uploadLinkPath;

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadLinkPath() {
		return uploadLinkPath;
	}

	public void setUploadLinkPath(String uploadLinkPath) {
		this.uploadLinkPath = uploadLinkPath;
	}

}
