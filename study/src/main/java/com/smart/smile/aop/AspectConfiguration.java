package com.smart.smile.aop;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan(basePackages = "com.smart.smile.aop")
public class AspectConfiguration {

	/**
	 * 本包下的Person类
	 *
	 * @return
	 */
	@Bean
	public Person person() {
		return new Person("zhangsan", 20);
	}

	@Bean(value = "person2")
	public com.smart.smile.domain.Person createPerson() {
		return new com.smart.smile.domain.Person("李四",19);
	}

//	@Bean()
//	public Children children() {
//		return new Children("tom", 10);
//	}
}
