package com.slb;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
//		System.out.println(beanName);
//		System.out.println(bean);
		
		// modify the object here...
		
		return bean;
	}

}
