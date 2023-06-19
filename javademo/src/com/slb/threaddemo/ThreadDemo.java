package com.slb.threaddemo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class IncrementSalary implements Runnable {

	Employee employee;
	
	public IncrementSalary(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public void run() {
		try {
			employee.incrementSalary(2000);
			Thread.sleep(2000);
			System.out.println(employee);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Increment salary ** " + Thread.currentThread().getName());
	}

}

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		List<Employee> employees = new ArrayList<>();

		Employee emp1 = new Employee(2, "Ravi", 33433);
		Employee emp2 = new Employee(3, "Jhanvi", 33333);
		Employee emp3 = new Employee(43, "Rahul", 42444);
		Employee emp4 = new Employee(43, "Rahul", 44444);

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		List<Thread> threadsInExecution = new ArrayList<>();
		
		System.out.println("Start time ---" + LocalDateTime.now());
		
		for(Employee e : employees) {
			Runnable r = new IncrementSalary(e);
			Thread t = new Thread(r);
			t.start();
			System.out.println(t.getName());
			threadsInExecution.add(t);
//			t.join();
		}
		
		for(Thread t : threadsInExecution) {
			t.join();
			t.start();
		}
		
		System.out.println("End time ---" + LocalDateTime.now());
		
		System.out.println("Operation after increments are done! " + Thread.currentThread().getName());

//		for (int i = 0; i < 10; i++) {
//			Thread t = new Thread(new IncrementSalary());
//			t.start();
//
//		}

	}

}
