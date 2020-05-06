package com.smart.smile.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class TestLookup {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CommandConfiguration.class);
		CommandManager bean = ac.getBean(CommandManager.class);
		bean.process(1);
		bean.process(2);
		ac.registerShutdownHook();
	}

}
