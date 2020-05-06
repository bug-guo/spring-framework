package com.smart.smile.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class Children extends Person {

//	public Children(){
//		this("tom", 10);
//	}

	public Children(String name, int age) {
		super(name, age);
	}
}
