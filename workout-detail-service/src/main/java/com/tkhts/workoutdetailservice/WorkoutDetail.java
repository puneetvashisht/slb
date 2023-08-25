package com.tkhts.workoutdetailservice;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class WorkoutDetail {
	
	@Id
	private Long id;
	private String VideoUrl;
	private String WorkoutId;
	
	@Transient
	String port;
}
