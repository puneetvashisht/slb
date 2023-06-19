package com.slb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class TransferService {
	
	@Autowired
	TransferRepository transferRepository;
	
//	public TransferService(TransferRepository transferRepository) {
//		super();
//		this.transferRepository = transferRepository;
//	}
	
	

	public TransferRepository getTransferRepository() {
		return transferRepository;
	}



	public void setTransferRepository(TransferRepository transferRepository) {
		this.transferRepository = transferRepository;
	}



	public void execute() {
		System.out.println("Execute in transfer service");
		transferRepository.execute();
	}



	public boolean sendSms() {
		// TODO Auto-generated method stub
		return true;
	}

}
