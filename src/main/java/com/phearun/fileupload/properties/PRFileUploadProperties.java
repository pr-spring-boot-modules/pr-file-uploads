package com.phearun.fileupload.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pr")
public class PRFileUploadProperties {

	private String clientPath;

	private String serverPath;

	public String getClientPath() {
		return clientPath;
	}

	public void setClientPath(String clientPath) {
		this.clientPath = clientPath;
	}

	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	public void appendPath(String path) {
		this.clientPath += path;
		this.serverPath += path;
	}
}
