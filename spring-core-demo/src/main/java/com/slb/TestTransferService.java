package com.slb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransferService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		TransferService service = context.getBean(TransferService.class);
		service.execute();
		
		
//		context.

	}

}
