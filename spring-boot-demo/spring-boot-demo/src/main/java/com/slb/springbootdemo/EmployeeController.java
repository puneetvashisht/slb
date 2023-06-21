package com.slb.springbootdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slb.springbootdemo.entities.Employee;
import com.slb.springbootdemo.repos.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@RequestMapping(path = "/employees", method = RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}

}
