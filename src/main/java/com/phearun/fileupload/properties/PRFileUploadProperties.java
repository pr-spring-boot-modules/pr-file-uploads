package com.phearun.fileupload.properties;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Phearun Rath
 * @since 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "pr")
public class PRFileUploadProperties {

	/**
	 * Client Path is used for client to request the uploaded files. When not
	 * specified, /resources/assets/ will be used.
	 */
	private String clientPath = "/resources/assets/";

	/**
	 * Server Path specifies the directory where uploaded files will be stored.
	 * When not specified, /tmp/assets/ will be used. You can also use
	 * ${user.dir} to store in current project directory, ${user.home} to store
	 * in user directory, etc.
	 */
	private String serverPath = "/tmp/assets/";

	public String getClientPath() {
		return clientPath;
	}

	public void setClientPath(String clientPath) {
		this.clientPath = clientPath.endsWith("/") ? clientPath : clientPath + "/";
	}

	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath.endsWith("/") ? serverPath : serverPath + "/";
		this.createIfNotExists(new File(this.serverPath));
	}

	public String[] makeDirectory(String folder) {
		this.createIfNotExists(new File(this.serverPath + folder));
		return new String[] { this.serverPath + folder, this.clientPath + folder + "/" };
	}
	
	private void createIfNotExists(File file){
		if (!file.exists()) {
			file.mkdir();
		}
	}

}