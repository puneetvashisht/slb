package javademo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeTest {
	
	public static void printEmployees(List<Employee> employees, Predicate<Employee> p){
		for(Employee e : employees) {
			if(p.test(e))
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		
		Employee emp1 = new Employee(2, "Ravi", 33433);
		Employee emp2 = new Employee(3, "Jhanvi", 33333);
		Employee emp3 = new Employee(43, "Rahul", 44444);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
//		Print all
//		printEmployees(employees, new Condition() {	
//			@Override
//			public boolean test(Employee e) {
//				return true;
//			}
//		});
		
		printEmployees(employees, (e)->true);
		
		System.out.println("-------------Starting with R -----------");
		// Print starting with "R"
//		printEmployees(employees, new Condition() {	
//			@Override
//			public boolean test(Employee e) {
//				return e.name.startsWith("R");
//			}
//		});
		printEmployees(employees, (e)->e.name.startsWith("R"));
		
		
		System.out.println("-------------Salary greater than 40k -----------");
		printEmployees(employees, (e)->e.salary>40000);

	}

}
