package com.smart.smile.test.transaction;

import com.smart.smile.transaction.PersonService;
import com.smart.smile.transaction.UserService;
import com.smart.smile.transaction.config.TransactionConfiguration;
import com.smart.smile.transaction.impl.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransaction {

	private ApplicationContext applicationContext;

	@Before
	public void init() {
//		 applicationContext = new AnnotationConfigApplicationContext(TransactionConfiguration.class);

	}

	@Test
	public void test() throws PersonServiceImpl.CustomeException {
		applicationContext = new ClassPathXmlApplicationContext("spring/spring-transaction.xml");
		PersonService bean = applicationContext.getBean(PersonService.class);
		bean.getPerson();
		System.out.println();
	}

	@Test
	public void test2() throws PersonServiceImpl.CustomeException {
		applicationContext = new AnnotationConfigApplicationContext(TransactionConfiguration.class);
		PersonService bean = applicationContext.getBean(PersonService.class);
		bean.getPerson();
		System.out.println();
	}

	@Test
	public void testPrograme1() {
		applicationContext = new AnnotationConfigApplicationContext(TransactionConfiguration.class);
		UserService bean = applicationContext.getBean(UserService.class);
		bean.query();
	}
}
