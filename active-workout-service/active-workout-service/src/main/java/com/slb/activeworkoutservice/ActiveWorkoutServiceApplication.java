package com.slb.activeworkoutservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
public class ActiveWorkoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveWorkoutServiceApplication.class, args);
	}

}
