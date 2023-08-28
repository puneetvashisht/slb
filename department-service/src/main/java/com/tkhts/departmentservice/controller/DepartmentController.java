package com.tkhts.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tkhts.departmentservice.entity.Department;
import com.tkhts.departmentservice.repo.DepartmentRepo;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentRepo departmentRepo;
	
	@PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		
		return null;
	}
	
	@GetMapping("{department-code}")
	public ResponseEntity<Department> getDepartment(@PathVariable("department-code") String departmentCode){
		
		return null;
	}
}
