package com.phearun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phearun.fileupload.properties.PRFileUploadProperties;

@SpringBootApplication
public class App implements CommandLineRunner{
	
    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private PRFileUploadProperties fileProperties;
    
	@Override
	public void run(String... args) throws Exception {
		System.out.println(fileProperties.getClientPath());
		System.out.println(fileProperties.getServerPath());
	}
}
