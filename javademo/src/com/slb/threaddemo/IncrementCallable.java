package com.slb.threaddemo;

import java.util.concurrent.Callable;

public class IncrementCallable implements Callable<Double> {

	Employee employee;
	
	public IncrementCallable(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Double call() throws Exception {
		try {
			employee.incrementSalary(2000);
			Thread.sleep(2000);
			System.out.println(employee);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Increment salary ** " + Thread.currentThread().getName());
		return employee.getSalary();
	}

}
