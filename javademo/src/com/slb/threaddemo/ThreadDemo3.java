package com.slb.threaddemo;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo3 {
 //static ArrayBlockingQueue<String> strQueue = new ArrayBlockingQueue<String>(3);
 
 public static void main(String[] args) {
	 Thread t1 = new Thread(new Consumer());
	 t1.start();
	 
	 Thread t2 = new Thread(new Producer());
	 t2.start();
	 
//	double ran = Math.random()*1000;
//	System.out.println("double "+ran);
//	long i = Math.round(ran);
//	System.out.println("long "+ i);
	
	//System.out.println(Math.round((Math.random()*1000)));
}

}

class CommonUtil{
	static ArrayBlockingQueue<Long> strQueue = new ArrayBlockingQueue<Long>(10);
	  
}
class Consumer extends CommonUtil implements Runnable {
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//System.out.println("in Consumer "+strQueue);
//			System.out.println(i);
			while(true) {
				long i = Math.round((Math.random()*10000));
				strQueue.put(i);
				System.out.println("in Consumer "+strQueue);
				Thread.sleep(i);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Producer extends CommonUtil implements Runnable{
//	long i = Math.round((Math.random()*1000));
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				//System.out.println("in Producer "+strQueue);
				
				
				while(!strQueue.isEmpty()) {
					System.out.println("removing ****************"+strQueue.take());
				}
				
				System.out.println("in Producer "+strQueue);
				Thread.sleep(2000); 
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}