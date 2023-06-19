package com.slb.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAspect {
	
	@Before("execution(void com.slb.PartyService.letsParty())")
	public void checkGuestList() {
		System.out.println("Checking guest list...");
	}

}
