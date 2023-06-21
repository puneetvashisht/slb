package com.slb.springbootdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PatchMapping("/employees")
	public ResponseEntity<Void> updateEmployeeSalary(@RequestBody Employee employee) {
		System.out.println("Id is : " + employee.getId());
		ResponseEntity<Void> re = null;
		Optional<Employee> employeeFound = employeeRepository.findById(employee.getId());
		if(employeeFound.isPresent()) {
			Employee emp = employeeFound.get();
			emp.setSalary(employee.getSalary());
			re = new ResponseEntity<>(HttpStatus.NO_CONTENT);
			employeeRepository.save(emp);
		}
		else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	
	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable("id") int id) {
		try {
			employeeRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			System.out.println("Caught exception " + e.getMessage());
			throw new EmployeeNotFoundException(e.getMessage());
		}
		
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> fetchEmployee(@PathVariable("id") int id) {
		System.out.println("Id is : " + id);
		ResponseEntity<Employee> re = null;
		Optional<Employee> employeeFound = employeeRepository.findById(id);
		if(employeeFound.isPresent()) {
			re = new ResponseEntity<>( employeeFound.get(), HttpStatus.OK);
		}
		else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	@GetMapping("/employees/findbyname")
	public ResponseEntity<Employee> fetchEmployee(@RequestParam("name") String name) {
		System.out.println("Name is : " + name);
		ResponseEntity<Employee> re = null;
		Employee employeeFound = employeeRepository.findByName(name);
		if(employeeFound!=null) {
			re = new ResponseEntity<>( employeeFound, HttpStatus.OK);
		}
		else {
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}	
	
	@RequestMapping(path = "/employees", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}

}
