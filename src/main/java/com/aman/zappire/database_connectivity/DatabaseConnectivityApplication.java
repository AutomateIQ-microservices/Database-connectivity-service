package com.aman.zappire.database_connectivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DatabaseConnectivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseConnectivityApplication.class, args);
	}

}
