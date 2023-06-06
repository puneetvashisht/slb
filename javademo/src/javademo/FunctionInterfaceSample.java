package javademo;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FunctionInterfaceSample {
	public static void main(String[] args) {
		BiConsumer<Integer, Integer> test = (a,b) -> System.out.println(a+b);
		test.accept(10,20);
		
		BiPredicate<String, String> strTest = (str1, str2) -> str1.equals(str2);
		Boolean result = strTest.test("abc", "xyz");
		System.out.println(result);
		
		Predicate<Integer> testPred = (num1) -> (num1 > 10);
		Boolean resultPred = testPred.test(100);
		System.out.println(resultPred);
		
		
	}
	
	
	
}
