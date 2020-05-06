package com.smart.smile.transaction.impl;

import org.springframework.context.ApplicationEvent;

public class MyTransactionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7117469486400772352L;
	private String name;

	public MyTransactionEvent(Object source, String name) {
		super(source);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}


