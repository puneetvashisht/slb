package javademo;

public class GCDemo {
	
	
	public static void m1() {
		m1();
	}

	public static void main(String[] args) throws InterruptedException {
		m1();
		String str = new String("");
		for(int i=0;i<100000000;i++) {
			str += i;
			Thread.sleep(200);
		}

	}

}
