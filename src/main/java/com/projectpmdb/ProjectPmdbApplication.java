package com.projectpmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectPmdbApplication {

	 private int maxUploadSizeInMb = 10 * 1024 * 1024; // 10 MB
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectPmdbApplication.class, args);
	}

}
