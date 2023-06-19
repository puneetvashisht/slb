package com.slb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringJUnit4ClassRunner)
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:beans.xml")
public class TestTransferServiceImpl {
	
	@Autowired
	TransferService transferService;

	@Test
	public void testTransferService() {
		transferService.execute();
	}
	
	@Test
	public void testTransferServiceSendSms() {
		boolean result = transferService.sendSms();
		assertTrue(result);
	}

}
