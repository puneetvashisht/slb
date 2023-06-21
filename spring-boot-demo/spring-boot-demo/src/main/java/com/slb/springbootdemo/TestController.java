package com.slb.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slb.springbootdemo.entities.Employee;

@Controller
public class TestController {
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public Employee sayHello() {
		return new Employee(23, "Ravi", 34343.3);
	}

}
