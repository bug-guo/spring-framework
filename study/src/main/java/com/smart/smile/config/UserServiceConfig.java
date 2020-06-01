package com.smart.smile.config;

import com.smart.smile.domain.User;
import com.smart.smile.service.UserService;
import com.smart.smile.service.UserServiceBeanPostProcessor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(value = "com.smart.smile.*")
public class UserServiceConfig {

//	@Bean(name = "root")
//	public static User createRoot() {
//		User root = new User();
////		root.setUsername("root");
////		root.setSex("man");
////		root.setAge(20);
//		return root;
//	}

	@Bean(initMethod = "init",destroyMethod = "doDestroy")
//	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public UserService createService() {
//		UserService service = new UserService();
		return new UserService();
	}

	@Bean
	public static UserServiceBeanPostProcessor createUserServiceBeanPostProcessor() {
		return new UserServiceBeanPostProcessor();
	}
}
