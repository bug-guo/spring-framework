package com.smart.smile.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

/**
 * @Author Zhiguo Chen
 * @Date 2020/3/13 11:05
 */
public class MyApplicationEventListener implements ApplicationListener<MyApplicationEvent> {
	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("receiver: " + event.getSource() + ": " + event.getMessage());
	}
}