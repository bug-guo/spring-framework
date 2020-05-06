package com.smart.smile.test;

import com.smart.smile.config.UserServiceConfig;
import com.smart.smile.domain.Person;
import com.smart.smile.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class TestSpringIOC {

	public static void main(String[] args) {
		TestSpringIOC demo = new TestSpringIOC();
		demo.testBeanConfig();
	}

	/**
	 * 测试bean的装配方式
	 */
	public void testBeanConfig() {
		//1. xml装配

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringIOCConfig.class);

		//2. 实现BeanFactory接口
//		System.out.println(ac.getBean("myFactoryBean"));  // 获取该接口生成的对象
//		System.out.println(ac.getBean("&myFactoryBean"));  // 获取实现该接口的对象

		//3. 使用@Import 配置文件中可能已经注释该注解
//		System.out.println(ac.getBean(Person.class));
//		System.out.println(ac.getBean("person"));

		//4. 使用容器工厂，获取工厂注册bean
		DefaultListableBeanFactory factory = ac.getDefaultListableBeanFactory();		// 该工厂实现了注册接口
		factory.registerBeanDefinition("person", new RootBeanDefinition(Person.class));
		System.out.println(ac.getBean(Person.class));
		System.out.println(ac.getBean("person"));
	}

	/**
	 * 测试bean初始化的整个过程
	 */
	@Test
	public void testBeanInitProcess() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserServiceConfig.class);
//		User root = ac.getBean(User.class);
//		System.out.println(root);
		UserService service = ac.getBean(UserService.class);
		System.out.println(service);
		ac.close();
	}

	@Test
	public void tt() {

	}
}
