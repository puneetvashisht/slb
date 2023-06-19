package com.slb.threaddemo;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingDemo {

	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);
		
//		bq.put("item1");
//		bq.put("item2");
//		
//		System.out.println(bq);
		
		String removed = bq.take();
		System.out.println("removed .." + removed);
		
		bq.put("item3");
		
		System.out.println(bq);

	}

}
