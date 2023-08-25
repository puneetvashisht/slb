package com.slb.activeworkoutservice.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.slb.activeworkoutservice.dto.Workout;

@FeignClient(name = "workout-service")
//@RibbonClient(name="some-service")
public interface WorkoutDetailServiceProxy {
	@GetMapping(path ="/api/v1/workouts/{id}")
	public Workout fetchWorkout(@PathVariable("id") int id) ;
}
