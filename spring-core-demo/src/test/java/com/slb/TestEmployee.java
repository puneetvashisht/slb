package com.slb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.slb.entities.Employee;
import com.slb.repos.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:beans.xml")
public class TestEmployee {
	
	@Autowired
	EmployeeRepository repo;

//	@Test
	public void testInsertingEmployee() {
		Employee emp = new Employee("Sunaina");
		emp.setSalary(20000d);
		repo.addEmployee(emp);
	
	}
//	@Test
	public void testFindingEmployee() {
		repo.findEmployee(2);
	}
//	@Test
	public void testRemovingEmployee() {
		repo.removeEmployee(2);
	}
	
//	@Test
	public void testUpdatingEmployeeSalary() {
		repo.updateEmployee(1, 30000d);
	}
	@Test
	public void testFindingEmployeeByName() {
		Employee emp = repo.findByName("Sunaina");
		assertEquals( emp.getName(), "Sunaina");
	}
//	@Test
	public void testFindingEmployeesBySalary() {
		List<Employee> employees = repo.findBySalary(25000d);
//		assertEquals("should return one emp with name", employees.size(), 1);
	}


}
