package com.smart.smile.context.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Author Zhiguo Chen
 * @Date 2020/3/13 11:11
 */
@Component
public class MyApplicationEventPublisher  {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void publish(String message) {
		MyApplicationEvent event = new MyApplicationEvent(message, this);
		publisher.publishEvent(event);
	}
}
