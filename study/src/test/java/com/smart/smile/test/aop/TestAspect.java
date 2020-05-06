package com.smart.smile.test.aop;

import com.smart.smile.aop.AspectConfiguration;
import com.smart.smile.aop.Children;
import com.smart.smile.aop.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAspect {

	private AnnotationConfigApplicationContext applicationContext;

	@Before
	public void init() {
		applicationContext = new AnnotationConfigApplicationContext(AspectConfiguration.class);
	}

	@Test
	public void testAOPBefore() throws Exception {
		// 获取实例 com.smart.smile.aop.Person
		Person bean = applicationContext.getBean(Person.class);
		bean.sayHello();
		System.out.println();
		//
//		bean.sayWeClome();
	}

//	@Test
//	public void testWithin() {
//		// 获取实例 com.smart.smile.aop.Person
//		Person bean = applicationContext.getBean(Person.class);
//		bean.sayHello();
//
//		// 获取实例 com.smart.smile.domain.Person
//		com.smart.smile.domain.Person domainPerson = (com.smart.smile.domain.Person) applicationContext.getBean("person2");
//		domainPerson.sayHello();
//	}
//
//	@Test
//	public void testTarget() {
//		Children person = applicationContext.getBean(Children.class);
//		person.sayHello();
////		Address address = new Person("zhang",1);
//	}

	@Test
	public void test() {

	}
}
