package com.slb.activeworkoutservice.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.client.RestTemplate;

import com.slb.activeworkoutservice.dto.Workout;
import com.slb.activeworkoutservice.entities.ActiveWorkout;
import com.slb.activeworkoutservice.repos.ActiveWorkoutRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/activeworkouts")
@Slf4j
public class ActiveWorkoutController {
	@Autowired
	ActiveWorkoutRepository activeWorkoutRepository;
	
	@Autowired
	WorkoutServiceProxy workoutServiceProxy;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addWorkout(@RequestBody ActiveWorkout workout) {
		workout.setWorkoutDate(LocalDate.now());
		workout.setStartTime(LocalTime.now());
		activeWorkoutRepository.save(workout);
	}
	
	@GetMapping("/")
	public List<ActiveWorkout> fetchAllWorkouts() {
		return activeWorkoutRepository.findAll();
	}
	
	@GetMapping("/feign/{id}")
//	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public ResponseEntity<ActiveWorkout> fetchAllWorkoutsUsingFeign(@PathVariable("id") int id) {
		Optional<ActiveWorkout> activeWorkoutFound = activeWorkoutRepository.findById(id);
		if(activeWorkoutFound.isPresent()) {
			ActiveWorkout activeWorkout = activeWorkoutFound.get();

			// invoke using open feign
			Workout workout = workoutServiceProxy.fetchWorkout(activeWorkout.getWorkoutId());
			
			System.out.println("Fetched workout from other service : " + workout);
			activeWorkout.setWorkout(workout);
			
			return new ResponseEntity<ActiveWorkout>(activeWorkout, HttpStatus.OK);
		}
		activeWorkoutFound.orElseThrow();
//		else {
////			return new ResponseEntity<ActiveWorkout>(HttpStatus.NOT_FOUND);
//			
//		}
		return null;
		
		
//		Optional<ActiveWorkout> activeWorkoutFound = activeWorkoutRepository.findById(id);
//		activeWorkoutFound.ifPresentOrElse(new Consumer<Optional<ActiveWorkout>>() {
//
//			@Override
//			public void accept(Optional<ActiveWorkout> activeWorkoutFound) {
//				// TODO Auto-generated method stub
//				ActiveWorkout activeWorkout = activeWorkoutFound.get();
//
//				// invoke using open feign
//				Workout workout = workoutServiceProxy.fetchWorkout(activeWorkout.getWorkoutId());
//				
//				System.out.println("Fetched workout from other service : " + workout);
//				activeWorkout.setWorkout(workout);
//				
//			}
//			
//		}, null);
//		
//		return null;
	}
	
	@GetMapping("/{id}")
//	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public ActiveWorkout fetchAllWorkouts(@PathVariable("id") int id) {
		Optional<ActiveWorkout> activeWorkoutFound = activeWorkoutRepository.findById(id);
		if(activeWorkoutFound.isPresent()) {
			ActiveWorkout activeWorkout = activeWorkoutFound.get();
			// invoke other service running on port 8080
			
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("id", activeWorkout.getWorkoutId() + "");
//			uriVariables.put("destination", destination);
			
			ResponseEntity<Workout> workoutEntity =  new RestTemplate().getForEntity(
					"http://localhost:8080/api/v1/workouts/{id}", 
					Workout.class,
					uriVariables);
			
			Workout workout = workoutEntity.getBody();
			
			System.out.println("Fetched workout from other service : " + workout);
			activeWorkout.setWorkout(workout);
			
			return activeWorkout;
		}
		
		return null;
	}
	
	public ResponseEntity<ActiveWorkout> fallbackMethod(int id) {
        System.out.println("workout-service is down!!! fallback route enabled...");
        return new ResponseEntity<ActiveWorkout>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
