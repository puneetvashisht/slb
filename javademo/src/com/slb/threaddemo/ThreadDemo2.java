package com.slb.threaddemo;

class InventoryTask implements Runnable{
	
	 Integer totalProducts = 1000;
	
//	synchronized static void buy() {
//		totalProducts = totalProducts - 1;
//	}
	
	@Override
	public void run() {
		
		synchronized (this) {
			totalProducts = totalProducts - 1;
		}
		
//		buy();
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total remaining " + totalProducts);
	}
	
}

public class ThreadDemo2 {

	public static void main(String[] args) {
		
		Runnable r = new InventoryTask();
		
		for(int i=0;i<1000;i++) {
			Thread t1 = new Thread(r);
			t1.start();
		}
		
	}

}
