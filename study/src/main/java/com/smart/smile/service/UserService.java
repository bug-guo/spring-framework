package com.smart.smile.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;

public class UserService implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware,
//			BeanPostProcessor,
//		BeanFactoryPostProcessor,
		InitializingBean, DisposableBean {

	public UserService() {
		System.out.println("创建UserService实例");
	}


	public void init() {
		System.out.println("UserService的init方法");
	}

	public void doDestroy() {
		System.out.println("UserService的doDestroy方法");
	}

	/**
	 * 该注解使用了CommonAnnotationBeanPostProcessor
	 */
	@PostConstruct
	public void post() {
		System.out.println("UserService的postConstruct方法");
	}


	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("调用BeanClassLoaderAware的setBeanClassLoader方法");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用BeanFactoryAware的setBeanFactory方法");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("调用BeanNameAware的setBeanName方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean的destroy方法");
	}

	/**
	 * InitializingBean 接口的方法
	 *
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean的afterPropertiesSet");
	}

//	@Override
//	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		System.out.println("UserService的postProcessBeanFactory");
//	}
//
//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
////		if (beanName.equals("userService")) {
//			System.out.println("UserService的postProcessBeforeInitialization");
////		}
//		return bean;
//	}
//
//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
////		if (beanName.equals("userService")) {
//			System.out.println("UserService的postProcessAfterInitialization");
////		}
//		return bean;
//	}

}
