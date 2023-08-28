package com.tkhts.departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tkhts.departmentservice.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
	
}
