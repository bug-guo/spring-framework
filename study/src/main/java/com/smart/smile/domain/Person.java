package com.smart.smile.domain;

public class Person {
	private String name;
	private int age;

	public Person() {

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void sayHello() {
		System.out.println(String.format("Hello! My name is %s and my age is %d", this.name, this.age));
	}
}
