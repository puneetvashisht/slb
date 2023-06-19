package com.slb;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class TransferRepository {

	public void execute() {
		System.out.println("Execute in transfer repository");
		
	}

}
