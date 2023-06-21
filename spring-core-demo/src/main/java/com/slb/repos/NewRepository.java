package com.slb.repos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.slb.entities.Employee;

@Repository
public class NewRepository {
	@PersistenceContext
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void incrementUpdatedTimes(int id) {
		Employee emp = em.find(Employee.class, id);
		emp.setTimesUpdated(emp.getTimesUpdated() + 1);
		
	}
}
