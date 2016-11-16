package com.easycode;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easycode.UserController;

public class ValidateTest {
	
	ApplicationContext context = null;
	UserController userController = null;
	@Before
	public void before() throws Exception {
	    context = new ClassPathXmlApplicationContext("classpath:/spring/*.xml");
	    userController = (UserController) context.getBean("userController");
	}
	
	@Test
	public void testValidate(){
		System.out.println(userController.addUsers("xiaoyu", "123456",1001).toString());
	}
}
