package com.tkhts.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tkhts.employeeservice.entity.Employee;
import com.tkhts.employeeservice.repo.EmployeeRepo;
import com.tkhts.employeeservice.response.APIResponse;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		
		return null;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<APIResponse> getEmployee(@PathVariable("id") Long employeeId){
		
		return null;
	}
}
