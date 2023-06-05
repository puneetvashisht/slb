package javademo;

import java.util.function.BiFunction;

public class FunctionsDemo {
	
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a+b;
		Integer result = biFunction.apply(23, 33);
		System.out.println(result);
	}

}
