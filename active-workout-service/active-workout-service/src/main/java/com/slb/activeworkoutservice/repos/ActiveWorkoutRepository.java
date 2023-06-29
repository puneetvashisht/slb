package com.slb.activeworkoutservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slb.activeworkoutservice.entities.ActiveWorkout;

public interface ActiveWorkoutRepository extends JpaRepository<ActiveWorkout, Integer> {

}
