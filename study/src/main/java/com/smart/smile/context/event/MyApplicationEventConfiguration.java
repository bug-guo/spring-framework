package com.smart.smile.context.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Zhiguo Chen
 * @Date 2020/3/13 11:08
 */
@Configuration
@ComponentScan(basePackages = {"com.smart.smile.context.event"})
public class MyApplicationEventConfiguration {

	@Bean
	public ApplicationListener<MyApplicationEvent> createApplicationListener() {
		return new MyApplicationEventListener();
	}


}
