package com.smart.smile.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//@Component
public class UserServiceBeanPostProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		if (beanName.equals("userService")) {
//			System.out.println("UserService的postProcessBeforeInitialization");
			System.out.println("调用BeanPostProcessor的postProcessBeforeInitialization方法");
//		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		if (beanName.equals("userService")) {
//			System.out.println("UserService的postProcessAfterInitialization");
//		}
		System.out.println("调用BeanPostProcessor的postProcessAfterInitialization方法");
		return null;
	}

	/**
	 * BeanFactoryPostProcessor 实现方法
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		System.out.println("UserService的postProcessBeanFactory");
		System.out.println("调用BeanFactory的postProcessBeanFactory方法");
	}
}
