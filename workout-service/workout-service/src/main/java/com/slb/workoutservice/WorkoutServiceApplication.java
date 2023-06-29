package com.slb.workoutservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WorkoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutServiceApplication.class, args);
	}

}
