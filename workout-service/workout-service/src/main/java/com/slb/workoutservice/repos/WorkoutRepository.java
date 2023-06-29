package com.slb.workoutservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slb.workoutservice.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}
