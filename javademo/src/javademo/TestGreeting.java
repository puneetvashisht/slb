package javademo;

public class TestGreeting {

	public static void main(String[] args) {
//		Language l = () -> System.out.println("hello lamda");
		Greeting greeting = new Greeting();
		greeting.sayHello(() -> System.out.println("hello lamda"));
		
		
		Runnable runnable = ()-> System.out.println(Thread.currentThread().getName());
		Thread t = new Thread(runnable);
		t.start();
		
//		Language j = new JapaneseLanguage();
//		
//		Greeting greeting = new Greeting();
//		greeting.sayHello(new Language() {
//			
//			@Override
//			public void greet() {
//				System.out.println("Hi");
//				
//			}
//		});
		
		

	}

}
