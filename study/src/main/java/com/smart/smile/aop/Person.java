package com.smart.smile.aop;

//@Scope(DefaultListableBeanFactory.SCOPE_PROTOTYPE)
public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void sayHello() throws InterruptedException {
		System.out.println(String.format("Hello! My name is %s and my age is %d", this.name, this.age));
//		throw new InterruptedException("ss");
//		((Person) AopContext.currentProxy()).weClome();
//		this.sayWeClome();
	}

	public void sayWeClome() {
		System.out.println("Welcome to Person Class!");
	}

	public void weClome() {
		System.out.println("Welcome to Person Class!");
	}


}
