package com.slb.repos;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slb.entities.Employee;

@Repository
public class EmployeeRepository {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	NewRepository newRepository;

	@Transactional
	public void addEmployee(Employee emp) {
		em.persist(emp);
	}

	public void findEmployee(int id) {
		Employee emp = em.find(Employee.class, id);
		System.out.println(emp);
	}

	@Transactional
	public void removeEmployee(int id) {
		Employee emp = em.find(Employee.class, id);
		em.remove(emp);
	}

	@Transactional
	public void updateEmployee(int id, double salary){
		Employee emp = em.find(Employee.class, id);
		emp.setSalary(salary);
		newRepository.incrementUpdatedTimes(id);
		
		if(salary < 10000) {
			throw new RuntimeException("Salary cant be less than minimum!");
		}
		System.out.println(emp);
		
	}
	
	

	public Employee findByName(String name) {
		TypedQuery<Employee> query = em.createNamedQuery("findEmployeeByName", Employee.class);
		query.setParameter("name", name);
		Employee emp = query.getSingleResult();
		System.out.println(emp);
		return emp;
	}
	

	public List<Employee> findBySalary(double salary) {
		TypedQuery<Employee> query = em.createNamedQuery("findEmployeeBySalary", Employee.class);
		query.setParameter("salary", salary);
		List<Employee> employees = query.getResultList();
		System.out.println(employees);
		return employees;
	}

}

