package com.smart.smile.context.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author Zhiguo Chen
 * @Date 2020/3/13 10:50
 */
public class MyApplicationEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3652314683872247054L;
	private String message;

	public MyApplicationEvent(String message, Object source) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
