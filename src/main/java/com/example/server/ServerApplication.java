package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@EnableWebMvc
@SpringBootApplication
//@EnableEurekaClient
public class ServerApplication {

	public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
	}
}
