package com.tkhts.workoutdetailservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/workout/detail")
public class WorkoutDetailController {
	
	@Autowired
	WorkoutDetailRepository workoutDetailRepository;
	
	@Value("${server.port}")
	String port;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<WorkoutDetail> addWorkout(@RequestBody WorkoutDetail workoutDetail) {
		WorkoutDetail savedWorkoutDetail = workoutDetailRepository.save(workoutDetail);
		return new ResponseEntity<WorkoutDetail>(savedWorkoutDetail, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<WorkoutDetail>> fetchAllWorkouts() {
		return new ResponseEntity<List<WorkoutDetail>>(workoutDetailRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WorkoutDetail> fetchAllWorkouts(@PathVariable("id") Long id) {
		System.out.println("port " + port);
		Optional<WorkoutDetail> workoutDetailFound = workoutDetailRepository.findById(id);
		if(workoutDetailFound.isPresent()) {
			WorkoutDetail workoutDetail = workoutDetailFound.get();
			workoutDetail.setPort(port);
			return new ResponseEntity<WorkoutDetail>(workoutDetail, HttpStatus.OK);
		}
		
		return null;
	}
	

}
