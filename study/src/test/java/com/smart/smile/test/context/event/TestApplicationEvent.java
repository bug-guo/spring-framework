package com.smart.smile.test.context.event;

import com.smart.smile.context.event.MyApplicationEventConfiguration;
import com.smart.smile.context.event.MyApplicationEventPublisher;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Zhiguo Chen
 * @Date 2020/3/13 11:15
 */
public class TestApplicationEvent {

	@Test
	public void testAppEvent() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationEventConfiguration.class);
		MyApplicationEventPublisher publisher = context.getBean(MyApplicationEventPublisher.class);
		publisher.publish("hello application event");
	}
}
