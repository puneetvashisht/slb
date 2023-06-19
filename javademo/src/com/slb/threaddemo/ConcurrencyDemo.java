package com.slb.threaddemo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ConcurrencyDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Thread Pool
//		ExecutorService service2 = Executors.;
		
		
		
		ExecutorService service =  new ThreadPoolExecutor(2, 4,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2));
		
		List<Employee> employees = new ArrayList<>();

		Employee emp1 = new Employee(2, "Ravi", 33433);
		Employee emp2 = new Employee(3, "Jhanvi", 33333);
		Employee emp3 = new Employee(43, "Rahul", 42444);
		Employee emp4 = new Employee(43, "Rahul", 44444);
		Employee emp6 = new Employee(43, "Rahul", 42444);
		Employee emp5 = new Employee(43, "Rahul", 44444);
		Employee emp7 = new Employee(43, "Rahul", 44444);

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
//		employees.add(emp7);
		

		System.out.println("Start time ---" + LocalDateTime.now());
		
		List<Future> futures = new ArrayList<>();
		
		for(Employee e : employees) {
			Callable<Double> r = new IncrementCallable(e);
			 Future<Double> f = service.submit(r);
			 
			 futures.add(f);
			
		}
		double totalSalariesNow = 0;
		for(Future<Double> f: futures) {
			 //blocking method
			 double result  = f.get();
			 totalSalariesNow += result;
			 System.out.println("Incremented salary is : " + result);
		}
		
		System.out.println("Total Salary now paid by org: " + totalSalariesNow);
		
		System.out.println("End time ---" + LocalDateTime.now());
		service.shutdown();

	}

}
