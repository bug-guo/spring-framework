package com.smart.smile;

import com.smart.smile.config.UserServiceConfig;
import com.smart.smile.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserServiceConfig.class);
//		User root = ac.getBean(User.class);
//		System.out.println(root);
		UserService service = ac.getBean(UserService.class);
		System.out.println(service);
		ac.close();
	}
}
