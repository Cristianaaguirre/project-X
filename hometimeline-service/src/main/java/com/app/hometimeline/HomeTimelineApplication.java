package com.app.hometimeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HomeTimelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeTimelineApplication.class, args);
	}

}
