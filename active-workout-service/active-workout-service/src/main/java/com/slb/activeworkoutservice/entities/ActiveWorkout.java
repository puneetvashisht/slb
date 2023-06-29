package com.slb.activeworkoutservice.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.slb.activeworkoutservice.dto.Workout;

@Entity
public class ActiveWorkout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	LocalDate workoutDate;
	LocalTime startTime;
	LocalTime endTime;
	@Transient
	Workout workout;
	int workoutId;
	
	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public LocalDate getWorkoutDate() {
		return workoutDate;
	}




	public void setWorkoutDate(LocalDate workoutDate) {
		this.workoutDate = workoutDate;
	}




	public LocalTime getStartTime() {
		return startTime;
	}




	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}




	public LocalTime getEndTime() {
		return endTime;
	}




	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}




	public Workout getWorkout() {
		return workout;
	}




	public void setWorkout(Workout workout) {
		this.workout = workout;
	}




	public int getWorkoutId() {
		return workoutId;
	}




	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}




	@Override
	public String toString() {
		return "ActiveWorkout [id=" + id + ", workoutDate=" + workoutDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", workoutId=" + workoutId + "]";
	}
	
	
	
	
	

}
