package com.slb.workoutservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.slb.workoutservice.entities.Workout;
import com.slb.workoutservice.repos.WorkoutRepository;

@RestController
@RequestMapping("/api/v1/workouts")
public class WorkoutController {
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addWorkout(@RequestBody Workout workout) {
		workoutRepository.save(workout);
	}
	
	@GetMapping("/")
	public List<Workout> fetchAllWorkouts() {
		return workoutRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Workout> fetchAllWorkouts(@PathVariable("id") int id) {
		return new ResponseEntity(workoutRepository.findById(id).get(), HttpStatus.OK);
	}

}
