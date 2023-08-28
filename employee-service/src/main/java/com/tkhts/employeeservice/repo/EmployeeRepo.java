package com.tkhts.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tkhts.employeeservice.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
