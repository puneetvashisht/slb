package javademo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmployeeTest {
	
	public static void printEmployees(List<Employee> employees, Predicate<Employee> p, Consumer<Employee> c){
		for(Employee e : employees) {
			if(p.test(e))
			c.accept(e);
		}
	}

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		
		Employee emp1 = new Employee(2, "Ravi", 33433);
		Employee emp2 = new Employee(3, "Jhanvi", 33333);
		Employee emp3 = new Employee(43, "Rahul", 42444);
		Employee emp4 = new Employee(43, "Rahul", 44444);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		System.out.println(employees);
		
		employees.stream()
		// Intermediate
		.filter(e-> { 
			System.out.println("***"  + e);
			return e.name.startsWith("R"); })
//		.distinct()
//		.skip(1)
		// Terminal
		.forEach(System.out::println);
//		.forEach((e)-> System.out.println(e))
		
		
		
//		OptionalDouble maxSalary = employees.stream()
////		.map(e -> e.name)
//		.mapToDouble(e-> e.salary)
//		.max();
////		.forEach(System.out::println);
//		
//		if(maxSalary.isPresent()) {
//			System.out.println("Max salary is " + maxSalary.getAsDouble());
//		}
//		
//		
//		employees.stream()
//		.sorted((e1, e2)-> (int)(e1.salary - e2.salary))
//		.forEach(System.out::println);
		
//		String fruit = "apple";
//		String pineapple = "pineapple";
//				
//		List<String> fruits = new ArrayList<>();
//		fruits.add(fruit); fruits.add(pineapple);
		
		System.out.println(employees.contains(new Employee(3, "Jhanvi", 33333)));
		
		
//		
		
//		Print all
//		printEmployees(employees, new Condition() {	
//			@Override
//			public boolean test(Employee e) {
//				return true;
//			}
//		});
		
		printEmployees(employees, (e)->true, (e)->System.out.println(e));
		printEmployees(employees, (e)->true, System.out::println);
		
		System.out.println("-------------Starting with R -----------");
		// Print starting with "R"
//		printEmployees(employees, new Condition() {	
//			@Override
//			public boolean test(Employee e) {
//				return e.name.startsWith("R");
//			}
//		});
		printEmployees(employees, (e)->e.name.startsWith("R"), System.out::println);
		
		
		System.out.println("-------------Salary greater than 40k -----------");
		printEmployees(employees, (e)->e.salary>40000, System.out::println);
		
		// employees.sort
		
//		Collections.sort(employees, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// TODO Auto-generated method stub
//				return o1.name.compareTo(o2.name);
//			}
//		});
//		
//		Collections.sort(employees, (o1,o2) -> o1.name.compareTo(o2.name));
		
		System.out.println(employees);

	}

}
