package com.slb.springbootdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slb.springbootdemo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
